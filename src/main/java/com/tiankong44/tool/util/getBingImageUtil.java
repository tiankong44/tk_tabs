package com.tiankong44.tool.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tiankong44.tool.common.entity.BingImage;
import com.tiankong44.tool.common.entity.Image;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/11/2  16:08
 **/
public class getBingImageUtil {
    private static String URL = "https://cn.bing.com/HPImageArchive.aspx?";  // 返回格式 json
    private static String format = "js";  // 返回格式 json
    private static String mkt = "zh-CN"; // 地区
    private static String idx = "0";  //请求图片截止天数
    private static String n = "8";  //请求数量


    public static List<Image> getImages() {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<String, String>();
        map.put("format", format);
        map.put("mkt", mkt);
        map.put("idx", idx);
        map.put("n", n);
        String img = restTemplate.getForObject(URL + "format={format}&idx={idx}&n={n}&mkt={mkt}", String.class, map);
        JSONObject jsonObject = JSONObject.parseObject(img);
        // 下面 这个数组里面就是获取到的壁纸集合信息
        JSONArray array = jsonObject.getJSONArray("images");

        String content;
        List<Image> images = new ArrayList<Image>();
        for (Object o : array) {
            Image image = new Image();
            BingImage bingImage = JSONObject.toJavaObject((JSON) JSONObject.toJSON(o), BingImage.class);
            image.setUrl("https://cn.bing.com" + bingImage.getUrl());
            content = bingImage.getCopyright();
            if (content.length() > 0) {
                String addr = content.substring(0, content.indexOf("("));
                image.setCopyright(addr);
                images.add(image);
            }
        }
        return images;
    }
}
