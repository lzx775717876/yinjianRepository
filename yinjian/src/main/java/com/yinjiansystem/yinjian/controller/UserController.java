package com.yinjiansystem.yinjian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.User;
import com.yinjiansystem.yinjian.service.UserService;
import com.yinjiansystem.yinjian.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 用户 Controller层
 * @Author HCX + DT
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

}
