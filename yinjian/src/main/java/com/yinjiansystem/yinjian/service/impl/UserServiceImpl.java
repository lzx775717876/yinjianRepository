package com.yinjiansystem.yinjian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.dao.UserMapper;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.TestService;
import com.yinjiansystem.yinjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 测试 Service层实现类
 * @Author HCX
 * @Date 2020/11/28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<User> selectById(Integer pageNum, Integer pageSize,User user) {
        PageHelper.startPage(pageNum, pageSize);

        List<User> list = userMapper.selectById(user);
        return new PageInfo<>(list);
    }

}
