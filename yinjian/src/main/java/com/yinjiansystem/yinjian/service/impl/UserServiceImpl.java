package com.yinjiansystem.yinjian.service.impl;

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
    public List<User> selectById() {
        List<User> list = userMapper.selectById();
        return list;
    }
}
