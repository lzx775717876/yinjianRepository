package com.yinjiansystem.yinjian.pojo;

import lombok.Data;

/**
 * @Description 氪金记录 实体类
 * @Author DT
 * @Date 2020/11/27
 */
@Data
public class Buy extends BaseModel {

    //用户id
    private Long userId;

    //游戏名
    private String gameName;

    //氪金类型 0-虚拟 1-实体
    private Integer type;

    //金额
    private String money;

    //备注
    private String remark;

    //图片地址
    private String photoPath;
}
