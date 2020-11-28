package com.yinjiansystem.yinjian.controller;

import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description  Controller层
 * @Author HCX
 * @Date 2020/11/27
 */
@RestController
@RequestMapping("/User")
public class UserController {

    private static final String JSON = "application/json;charset=UTF-8";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     */
    @GetMapping(value = "/select")
    public List<User> selectAllById() {
        List<User> list = userService.selectById();
        return list;
    }


}
