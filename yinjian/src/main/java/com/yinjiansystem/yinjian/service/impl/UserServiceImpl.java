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

import java.sql.Wrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public IPage<User> selectById(Integer pageNum, Integer pageSize,User user) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        userPage = userMapper.selectPage(userPage, null);
        return userPage;
    }

    @Override
    public int insertUser(User user){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        try{
            Date creatTime = dateFormat.parse(dateFormat.format(date));
            Date updateTime = dateFormat.parse(dateFormat.format(date));
            user.setCreateTime(creatTime);
            user.setUpdateTime(updateTime);
            int result = userMapper.insert(user);
            return result;
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        try{
            Date updateTime = dateFormat.parse(dateFormat.format(date));
            user.setUpdateTime(updateTime);
            int result = userMapper.updateById(user);
            return result;
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

}
