package com.yinjiansystem.yinjian.enu;



/**
 * @Description 用户类型 枚举类
 * @Author DT
 * @Date 2020/11/30
 */
public enum USER_TYPE {

	HongGe(1),
	LuXi(2),
	JiE(3),
	TuoGe(4),
	Guest(5);

	private String code;
	private Integer num;

	private USER_TYPE(Integer num) {
		this.num = num;
		this.code = this.name();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public static USER_TYPE findByCode(String code) {
		for (USER_TYPE obj : USER_TYPE.values()) {
			if (obj.code.equals(code)) {
				return obj;
			}
		}
		return null;
	}
}
