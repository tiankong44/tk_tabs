package com.tiankong44.tool.common.service.Impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONArray;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.common.entity.Appearance;
import com.tiankong44.tool.common.entity.Image;
import com.tiankong44.tool.common.service.CommonService;
import com.tiankong44.tool.mapper.slave.AppearanceMapper;
import com.tiankong44.tool.util.RedisUtil;
import com.tiankong44.tool.util.getBingImageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/11/2  16:35
 **/
@Service

public class CommonServiceImpl implements CommonService {
    public static final String imageKey = "imageKey";

    @Resource
    RedisUtil redisUtil;

    @Resource
    AppearanceMapper appearanceMapper;

    private static String defaultImage = "https://cn.bing.com/th?id=OHR.BridgeofSighs_ZH-CN5414607871_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp";  // 图片地址前缀


    @Override
    public BaseRes getBackgroundImage() {
        Appearance appearance = appearanceMapper.selectById(1);
        if (appearance.getBackgroundMode() == 0) {
            String s = redisUtil.lLeftPop(imageKey);
            JSONArray array = JSONArray.parseArray(s);
            List<Image> images = new ArrayList<>();
            if (array == null || array.size() == 0) {
                images = getBingImageUtil.getImages();
                if (images.size() > 0) {
                    redisUtil.lLeftPush(imageKey, JSONArray.toJSON(images).toString());
                    redisUtil.expire(imageKey, 1, TimeUnit.DAYS);
                } else {
                    return BaseRes.success(defaultImage);
                }

            } else {
                images = array.toJavaList(Image.class);
            }

            return BaseRes.success(images.get(RandomUtil.randomInt(0, images.size())).getUrl());
        } else {
            return BaseRes.success(appearance.getBackgroundUrl());
        }
    }

}
