package com.yinjiansystem.yinjian.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description 游戏 实体类
 * @Author DT
 * @Date 2021/1/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "game")
public class Game extends BaseModel {

    @ApiModelProperty(value = "游戏名")
    private String name;

    @ApiModelProperty(value = "游戏类型 0-虚拟 1-实体")
    private Integer type;

    @ApiModelProperty(value = "游戏类型 预留")
    private Integer gameType;

}
