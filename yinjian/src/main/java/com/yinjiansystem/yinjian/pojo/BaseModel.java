package com.yinjiansystem.yinjian.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 基础 实体类
 * @Author DT
 * @Date 2020/11/27
 */
public class BaseModel implements Serializable{

	//主键id
	private String id;

	//创建时间
	private Date createTime;

	//修改时间
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
