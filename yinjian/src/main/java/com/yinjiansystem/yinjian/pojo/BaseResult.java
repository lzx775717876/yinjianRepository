package com.yinjiansystem.yinjian.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 通用返回数据格式
 * @Author DT
 * @Date 2020/12/30
 */
@ApiModel("通用返回数据格式")
public class BaseResult<T>  implements Serializable{

	@ApiModelProperty("请求结果：true 成功 false 失败")
	private boolean success;

	@ApiModelProperty("请求结果描述，成功为空 失败会有描述内容")
	private String msg;

	@ApiModelProperty("返回结果的时间戳")
	public long timeStamp = new Date().getTime();

	@ApiModelProperty("数据内容")
	private T data;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public void setSuccessAndMsg(boolean success,String msg){
		this.setSuccess(success);
		this.setMsg(msg);
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
		//如果插入数据，默认就成功
		this.success = true;
	}
}
