package com.tiankong44.tool.tab.service.Impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.mapper.master.TabMapper;
import com.tiankong44.tool.tab.entity.Tab;
import com.tiankong44.tool.tab.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

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
    public BaseRes listPrivate(Page<Tab> page, String password) {

        QueryWrapper<Tab> wrapper = new QueryWrapper<Tab>();
        wrapper.eq("individual", true).orderBy(true, true, "sort");
        page = tabMapper.selectPage(page, wrapper);
        return BaseRes.success(page);
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,";
        str = StringUtils.trimTrailingCharacter(str, ',');
        System.out.println(str);
    }


}

