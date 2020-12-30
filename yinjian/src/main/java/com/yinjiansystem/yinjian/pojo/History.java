package com.yinjiansystem.yinjian.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 历史信息 实体类
 * @Author DT
 * @Date 2020/12/23
 */
@Data
@TableName(value = "history")
public class History extends BaseModel {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "历史信息")
    private String message;

}
