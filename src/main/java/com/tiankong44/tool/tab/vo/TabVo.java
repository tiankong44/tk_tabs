package com.tiankong44.tool.tab.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.tiankong44.tool.app.entity.App;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Tab)表实体类
 *
 * @author makejava
 * @since 2022-11-01 13:21:27
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabVo extends Model<TabVo> {
    //主键
    private Long id;
    //名称
    private String name;
    //内部链接
    private String insideUrl;
    //外部链接
    private String externalUrl;
    //十六进制颜色-背景
    private String hex;
    //描述
    private String description;
    //是否私密
    private boolean individual;
    //排序
    private Integer sort;
    //图标地址
    private String icon;
}

