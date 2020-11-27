package com.yinjiansystem.yinjian.pojo;

/**
 * @Description 用户 实体类
 * @Author DT
 * @Date 2020/11/27
 */
public class User extends BaseModel {

    //姓名
    private String name;

    //用户名
    private String userName;

    //密码
    private String password;

    //用户类型
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
