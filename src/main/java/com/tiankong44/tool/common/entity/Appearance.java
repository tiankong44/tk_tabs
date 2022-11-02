package com.tiankong44.tool.common.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/11/2  16:39
 **/
@Data
public class Appearance extends Model<Appearance> {
    private Long id;
    private String backgroundUrl;
    private int backgroundMode;
}
