package com.tiankong44.tool.tab.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * (Tab)表实体类
 *
 * @author makejava
 * @since 2022-11-01 13:21:27
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tab extends Model<Tab> {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    //名称
    @NotNull(message = "应用名称不能为空")
    private String name;
    //内部链接
    @NotNull(message = "内部链接不能为空")
    private String insideUrl;
    //外部链接
    @NotNull(message = "外部链接不能为空")
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
    @NotNull(message = "图标地址不能为空")
    private String icon;
}

