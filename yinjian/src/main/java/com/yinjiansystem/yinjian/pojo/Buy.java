package com.yinjiansystem.yinjian.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 氪金记录 实体类
 * @Author DT
 * @Date 2020/11/27
 */
@Data
@TableName(value = "buy")
public class Buy extends BaseModel {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "游戏名")
    private String gameName;

    @ApiModelProperty(value = "氪金类型 0-虚拟 1-实体")
    private Integer type;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "图片地址")
    private String photoPath;
}
