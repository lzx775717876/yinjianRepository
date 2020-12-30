package com.yinjiansystem.yinjian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
@Api(value = "阴间用户", tags = { "阴间用户" })
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/selectPage", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public IPage<User> selectPage(
            @ApiParam(value = "页数", required = true) @PathVariable(value = "pageIndex",required = true) Integer pageIndex,
            @ApiParam(value = "展示数量", required = true) @PathVariable(value = "pageSize",required = true) Integer pageSize,
            @ApiParam(value = "用户信息", required = false) @RequestParam(value = "user", required = false) User user
    ) {
        IPage<User> page = userService.selectById(pageIndex,pageSize,user);
        return page;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "/insertUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public int insertUser(
            @ApiParam(value = "用户信息", required = false) @RequestParam(value = "user", required = false) User user
    ) {
        int result = userService.insertUser(user);
        return result;
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/updateUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.PUT)
    public int updateUser(
            @ApiParam(value = "用户信息", required = false) @RequestParam(value = "user", required = false) User user
    ) {
        int result = userService.updateUser(user);
        return result;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/updateUser", produces = Constant.PRODUCES_JSON, method = RequestMethod.DELETE)
    public int updateUser(
            @ApiParam(value = "用户id", required = true) @RequestParam(value = "id", required = true) Long id
    ) {
        int result = userService.deleteById(id);
        return result;
    }

}
