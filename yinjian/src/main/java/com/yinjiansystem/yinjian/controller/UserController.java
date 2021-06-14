package com.yinjiansystem.yinjian.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import com.yinjiansystem.yinjian.utils.Constant;
import com.yinjiansystem.yinjian.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户 Controller层
 * @Author HCX + DT + LZX
 * @Date 2020/11/27
 */
@RestController
@RequestMapping("/user")
@Api(value = "阴间用户模块", tags = { "阴间用户模块" })
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/selectPage", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public BaseResult<IPage<User>> selectPage(
            @ApiParam(value = "页数", required = true) @RequestParam(value = "pageIndex") Integer pageIndex,
            @ApiParam(value = "每页展示数量", required = true) @RequestParam(value = "pageSize") Integer pageSize
    ) {
        BaseResult<IPage<User>> br = new BaseResult<>();
        IPage<User> page = userService.selectPage(pageIndex,pageSize);
        br.setData(page);
        return br;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "/insertUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public BaseResult<String> insertUser(
            @ApiParam(value = "用户信息") @RequestBody(required = false) User user
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = userService.insertUser(user);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/updateUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.PUT)
    public BaseResult<String> updateUser(
            @ApiParam(value = "用户信息") @RequestBody(required = false) User user
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = userService.updateUser(user);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/deleteUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.DELETE)
    public BaseResult<String> deleteUser(
            @ApiParam(value = "用户id", required = true) @RequestParam(value = "id") Long id
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = userService.deleteById(id);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public Map userLogin(@ApiParam(value = "用户名或邮箱", required = true) @RequestBody User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        User loginUser = userService.userLogin(user.getUserName(), user.getPassword());
        if (loginUser == null) {
            resultMap.put("error", "error");
            return resultMap;
        }
        HashMap<String,Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,60);
        try {
            Map<String,String> payload = new HashMap<>();
            payload.put("userName", loginUser.getUserName());
            String token = JWTUtils.getToken(payload);
            resultMap.put("token", token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            resultMap.put("error", "JWTerror");
            return resultMap;
        }
        resultMap.put("loginUser", loginUser);
        return resultMap;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/getUserInfo", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public Map getUserInfo(@ApiParam(value = "认证token", required = true) @RequestBody Map tokenMap) {
        HashMap<String, Object> resultMap = new HashMap<>();
        User userInfo = userService.getUserInfo(tokenMap.get("token").toString());
        resultMap.put("userInfo", userInfo);
        return resultMap;
    }

}
