package com.tiankong44.tool.tab.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.tab.entity.Tab;
import com.tiankong44.tool.tab.service.TabService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * (Tab)表控制层
 *
 * @author makejava
 * @since 2022-11-01 13:21:27
 */
@RestController
@RequestMapping("tab")
public class TabController {
    /**
     * 服务对象
     */
    @Resource
    private TabService tabService;

    /**
     * 新增数据
     *
     * @param tab 实体对象
     * @return 新增结果
     */
    @PostMapping("/addTab")
    public BaseRes insert(@RequestBody @Valid Tab tab) {
        return tabService.addTab(tab);
    }

    /**
     * 查询可见的标签栏
     *
     * @param Page 实体对象
     * @return 新增结果
     */
    @PostMapping("/listPublic")
    public BaseRes listPublic(@RequestBody Page<Tab> Page) {
        return tabService.listPublic(Page);
    }

    /**
     * 查询私密标签栏
     *
     * @param page 实体对象
     * @return 新增结果
     */
    @PostMapping("/listPrivate")
    public BaseRes listPrivate(@RequestBody String msg) {

        return tabService.listPrivate(msg);
    }

    /**
     * 确认密码
     *
     * @return 新增结果
     */
    @PostMapping("/getPublicKey")
    public BaseRes getPublicKey() {
        return tabService.getPublicKey();
    }

    /**
     * 确认密码
     *
     * @return 新增结果
     */
    @PostMapping("/confirmPassword")
    public BaseRes confirmPassword(@RequestBody String password) {
        return tabService.confirmPassword(password);
    }
}

