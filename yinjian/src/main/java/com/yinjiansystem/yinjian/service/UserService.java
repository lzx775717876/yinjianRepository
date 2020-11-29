package com.yinjiansystem.yinjian.service;


import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.pojo.User;


/**
 * @Description  Service层
 * @Author HCX
 * @Date 2020/11/28
 */
public interface UserService {
    /**
     * 分页查询
     * @param user
     * */
    PageInfo<User> selectById(Integer pageNum, Integer pageSize,User user);

    /**
     * 插入
     * @param user
     * */
    int insertUser(User user);

    /**
     * 更新
     * @param user
     */
    int updateUser(User user);

    /**
     * 批量删除
     * @param ids
     */
    int deleteByIds(String ids);
}
