package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.dao.UserMapper;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description 测试 Service层实现类
 * @Author HCX + DT
 * @Date 2020/11/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPage(Integer pageNum, Integer pageSize,User user) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        userPage = userMapper.selectPage(userPage, null);
        return userPage;
    }

    @Override
    public int insertUser(User user){
        try{
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            return userMapper.insert(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        try{
            user.setUpdateTime(new Date());
            return userMapper.updateById(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

}
