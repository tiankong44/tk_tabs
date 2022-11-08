package com.tiankong44.tool.common.controller;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.base.entity.CommonResultStatus;
import com.tiankong44.tool.common.service.CommonService;
import com.tiankong44.tool.tab.entity.Tab;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    public BaseRes getBackgroundImage(int clientType) {
        return commonService.getBackgroundImage(clientType);
    }


    /**
     * 通用上传请求
     */
    @PostMapping("/uploadIcon")
    public BaseRes uploadIcon(@RequestParam(value = "file") MultipartFile file) throws Exception {
        return commonService.uploadIcon(file);
    }
}
