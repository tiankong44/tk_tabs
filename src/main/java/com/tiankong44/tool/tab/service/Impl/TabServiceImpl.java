package com.tiankong44.tool.tab.service.Impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.base.entity.CommonResultStatus;
import com.tiankong44.tool.mapper.master.SystemMapper;
import com.tiankong44.tool.mapper.master.TabMapper;
import com.tiankong44.tool.tab.entity.Tab;
import com.tiankong44.tool.tab.service.TabService;
import com.tiankong44.tool.util.RedisUtil;
import com.tiankong44.tool.util.RsaUtil;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


/**
 * (Tab)表服务实现类
 *
 * @author makejava
 * @since 2022-11-01 13:21:27
 */
@Service()
public class TabServiceImpl implements TabService {


    @Autowired
    TabMapper tabMapper;
    @Autowired
    SystemMapper systemMapper;
    @Autowired
    RedisUtil redisUtil;
    @Value("${publicKey}")
    private String publicKey;
    //引用私钥
    @Value("${privateKey}")
    private String privateKey;

    private static final String tokenKey = "lock_key";

    @Override
    @Transactional
    public BaseRes addTab(Tab tab) {
        tabMapper.insertTab(tab);
        return BaseRes.success(tab);
    }

    @Override
    @DS("slave")
    public BaseRes listPublic(Page<Tab> page) {

        QueryWrapper<Tab> wrapper = new QueryWrapper<Tab>();
        wrapper.eq("individual", false).orderBy(true, true, "sort");
        page = tabMapper.selectPage(page, wrapper);
        return BaseRes.success(page);
    }

    @Override
    @DS("slave")
    public BaseRes listPrivate(String msg) {
        JSONObject request = JSONObject.parseObject(msg);
        Page<Tab> page = request.getJSONObject("page").toJavaObject(Page.class);
        String token = request.getString("lockToken");
        if (StringUtils.isEmpty(token)) {
            return BaseRes.failure("请输入密码进入！");
        }
        String redisToken = redisUtil.get(tokenKey);
        if (StringUtils.isEmpty(redisToken)) {
            return BaseRes.failure(CommonResultStatus.TOKEN_TIMEOUT);
        }
        redisUtil.expire(tokenKey, 5, TimeUnit.MINUTES); //每次刷新更新5分钟有效期
        if (token.equals(redisToken)) {
            QueryWrapper<Tab> wrapper = new QueryWrapper<Tab>();
            wrapper.eq("individual", true).orderBy(true, true, "sort");
            page = tabMapper.selectPage(page, wrapper);

            // redisUtil.delete(tokenKey);
            return BaseRes.success(page);
        } else {
            return BaseRes.failure(CommonResultStatus.TOKEN_TIMEOUT);
        }

        /**
         *  验证临时token
         */


    }


    @Override
    public BaseRes getPublicKey() {
        if (StringUtils.isEmpty(publicKey)) {
            return BaseRes.failure(CommonResultStatus.NOK);
        } else {
            return BaseRes.success(publicKey);
        }

    }

    @Override
    @DS("slave")
    public BaseRes confirmPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return BaseRes.failure("密码不能为空");
        }
        /**
         *  对比密码
         *
         */
        String encodePassword = systemMapper.getPassword();
        if (StringUtils.isEmpty(encodePassword)) {
            return BaseRes.failure(CommonResultStatus.NO_PASSWORD);
        }
        String decode = RsaUtil.decode(password, privateKey);
        String decodePassword = RsaUtil.decode(encodePassword, privateKey);
        if (decode.equals(decodePassword)) {
            String token = StrUtil.uuid().replaceAll("-", "");
            redisUtil.setEx(tokenKey, token, 5, TimeUnit.MINUTES);
            return BaseRes.success(token);
        } else {
            return BaseRes.failure("密码错误");

        }
    }

}

