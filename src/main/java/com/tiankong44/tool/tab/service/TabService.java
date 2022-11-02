package com.tiankong44.tool.tab.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.tab.entity.Tab;

/**
 * (Tab)表服务接口
 *
 * @author makejava
 * @since 2022-11-01 13:21:27
 */
public interface TabService {

    BaseRes addTab(Tab tab);

    BaseRes listPublic(Page<Tab> page);

    BaseRes listPrivate(Page<Tab> page, String password);
}

