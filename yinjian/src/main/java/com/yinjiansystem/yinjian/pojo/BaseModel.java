package com.yinjiansystem.yinjian.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 基础 实体类
 * @Author DT
 * @Date 2020/11/27
 */
@Data
public class BaseModel implements Serializable{

	//主键id
	private Long id;

	//创建时间
	private Date createTime;

	//修改时间
	private Date updateTime;

}
