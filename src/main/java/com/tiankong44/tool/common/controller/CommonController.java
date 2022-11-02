package com.tiankong44.tool.common.controller;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.common.service.CommonService;
import com.tiankong44.tool.tab.entity.Tab;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/11/2  16:21
 **/
@RestController
@RequestMapping("common")
public class CommonController {


    @Resource
    CommonService commonService;

    /**
     * 获取bing壁纸地址
     *
     * @return 新增结果
     */
    @PostMapping("/getBackgroundImage")
    public BaseRes getBackgroundImage() {
      return  commonService.getBackgroundImage();
    }

}