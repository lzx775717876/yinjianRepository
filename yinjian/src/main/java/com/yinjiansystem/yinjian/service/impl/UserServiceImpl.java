package com.yinjiansystem.yinjian.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinjiansystem.yinjian.dao.UserMapper;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description 测试 Service层实现类
 * @Author HCX
 * @Date 2020/11/28
 */
@Service
public class UserServiceImpl implements UserService {
    private static final java.util.UUID UUID = null;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByMybatisPlus(long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public PageInfo<User> selectById(Integer pageNum, Integer pageSize,User user) {
        PageHelper.startPage(pageNum, pageSize);

        List<User> list = userMapper.selectByIdPage(user);
        return new PageInfo<>(list);
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
            int result = userMapper.insertUser(user);
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
            int result = userMapper.updateUser(user);
            return result;
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        return userMapper.deleteByIds(idArr);
    }

}
