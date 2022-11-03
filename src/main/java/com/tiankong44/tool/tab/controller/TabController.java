package com.tiankong44.tool.tab.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.tab.entity.Tab;
import com.tiankong44.tool.tab.service.TabService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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
    @PostMapping("/insert")
    public BaseRes insert(@RequestBody Tab tab) {
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
     * 新增数据
     *
     * @param Page 实体对象
     * @return 新增结果
     */
    @PostMapping("/listPrivate")
    public BaseRes listPrivate(@RequestBody Page<Tab> Page, String password) {
        return tabService.listPrivate(Page, password);
    }
}

