package com.yinjiansystem.yinjian.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.pojo.User;

import java.util.List;


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

	/**
     * mybatisplus查询测试
     * @param id
     */
    User selectByMybatisPlus(long id);
}
