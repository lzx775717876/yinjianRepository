package com.yinjiansystem.yinjian.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Description 拓哥贷 实体类
 * @Author DT
 * @Date 2021/1/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "loan")
public class Loan extends BaseModel {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "贷款状态 0-借贷中 1-已归还")
    private Integer status;

    @ApiModelProperty(value = "借款原因")
    private String reason;

    @ApiModelProperty(value = "归还时间")
    private Date returnTime;
}
