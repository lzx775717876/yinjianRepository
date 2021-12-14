package com.yinjiansystem.yinjian.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinjiansystem.yinjian.dao.UserMapper;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import com.yinjiansystem.yinjian.utils.JWTUtils;
import com.yinjiansystem.yinjian.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Description 测试 Service层实现类
 * @Author HCX + DT
 * @Date 2020/11/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPage(Integer pageNum, Integer pageSize) {
        Page<User> userPage = new Page<>(pageNum, pageSize);
        userPage.setDesc("id");
        return userMapper.selectPage(userPage, null);
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

    @Override
    public User userLogin(String userName, String password) {
        QueryWrapper<User> query = new QueryWrapper<>();

        if (!Utils.stringEmptyOrNull(userName) && !Utils.stringEmptyOrNull(password)){
            query.eq("userName", userName);
            query.eq("password", password);
        } else {
            return null;
        }
        return userMapper.selectOne(query);
    }

    @Override
    public User getUserInfo(String token) {
        try {
            DecodedJWT decodedToken = JWTUtils.getToken(token);
            String userName = decodedToken.getClaim("userName").asString();
            QueryWrapper<User> query = new QueryWrapper<>();
            query.eq("userName", userName);
            User user = userMapper.selectOne(query);
            user.setPassword(null);
            return user;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
