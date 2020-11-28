package com.yinjiansystem.yinjian.service;


import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.pojo.User;

import java.util.List;

/**
 * @Description  Service层
 * @Author HCX
 * @Date 2020/11/28
 */
public interface UserService {
    PageInfo<User> selectById(Integer pageNum, Integer pageSize,User user);

}
