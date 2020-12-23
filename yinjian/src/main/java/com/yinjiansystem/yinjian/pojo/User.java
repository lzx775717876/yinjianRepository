package com.yinjiansystem.yinjian.pojo;

import lombok.Data;

/**
 * @Description 用户 实体类
 * @Author DT
 * @Date 2020/11/27
 */
@Data
public class User extends BaseModel {

    //姓名
    private String name;

    //用户名
    private String userName;

    //密码
    private String password;

    //用户类型
    private Integer type;

}
