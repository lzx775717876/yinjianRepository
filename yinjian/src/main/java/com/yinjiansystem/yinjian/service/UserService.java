package com.yinjiansystem.yinjian.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.pojo.User;

import java.util.List;


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
     * @param user 用户信息
     * @return
     */
    IPage<User> selectPage(Integer pageNum, Integer pageSize, User user);

    /**
     * 新增用户
     * @param user 用户信息
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户
     * @param user 用户信息
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteById(Long id);

}
