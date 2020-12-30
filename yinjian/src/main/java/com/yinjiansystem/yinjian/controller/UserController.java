package com.yinjiansystem.yinjian.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description  Controller层
 * @Author HCX
 * @Date 2020/11/27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final String JSON = "application/json;charset=UTF-8";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * mybatisPlus测试用
     * @param
     */
    @GetMapping(value = "/mybatisPlusTest")
    public String mybatisPlusTest() {
        User user = userService.selectByMybatisPlus(2);
        String s = JSONObject.toJSONString(user);
        return s;
    }

    /**
     * 分页查询
     * @param user
     */
    @GetMapping(value = "/select")
    public IPage<User> selectAllById(Integer pageNum, Integer pageSize, User user) {
        IPage<User> page = userService.selectById(pageNum,pageSize,user);
        return page;
    }

    /**
     * 添加
     * @param user
     */
    @PostMapping(value = "/insert")
    public int insert(@RequestBody User user){
        int result = userService.insertUser(user);
        return result;
    }

    /**
     * 添加
     * @param user
     */
    @PostMapping(value = "/update")
    public int update(@RequestBody User user){
        int result = userService.updateUser(user);
        return result;
    }

    /**
     * 根据多文件ID的数组删除对应的附件记录
     *
     */
    @PostMapping(value = "/deleteByIds")
    public int deleteByIds(@RequestParam(value = "ids") Long id){
        int result = userService.deleteById(id);
        return result;
    }



}
