package com.yinjiansystem.yinjian.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 氪金记录 实体类
 * @Author DT
 * @Date 2020/11/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "pet")
public class Pet extends BaseModel {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "宠物花销")
    private String petItem;

    @ApiModelProperty(value = "花销类型")
    private String itemType;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "备注")
    private String remark;

}
