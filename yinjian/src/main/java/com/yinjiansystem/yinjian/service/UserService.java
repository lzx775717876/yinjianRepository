package com.yinjiansystem.yinjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.User;

/**
 * @Description 用户 Service层
 * @Author HCX + DT
 * @Date 2020/11/28
 */
public interface UserService {
    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页展示数量
     */
    IPage<User> selectPage(Integer pageNum, Integer pageSize);

    /**
     * 新增用户
     * @param user 用户信息
     */
    int insertUser(User user);

    /**
     * 修改用户
     * @param user 用户信息
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     */
    int deleteById(Long id);

    /**
     * 用户登录
     * @param userName 用户名或邮箱
     * @param password 密码
     */
    User userLogin(String userName, String password);

    /**
     * 获取用户信息
     * @param token 认证token
     */
    User getUserInfo(String token);

}
