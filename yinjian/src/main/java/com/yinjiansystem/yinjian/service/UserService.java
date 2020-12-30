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
     * @param user
     * */
    IPage<User> selectById(Integer pageNum, Integer pageSize, User user);

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
     * 删除
     * @param id
     */
    int deleteById(Long id);

}
