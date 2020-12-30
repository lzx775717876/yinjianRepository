package com.yinjiansystem.yinjian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.Buy;
import com.yinjiansystem.yinjian.service.BuyService;
import com.yinjiansystem.yinjian.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 氪金 Controller层
 * @Author DT
 * @Date 2020/12/30
 */
@RestController
@RequestMapping("/buy")
@Api(value = "阴间氪金模块", tags = { "阴间氪金模块" })
public class BuyController {

    @Autowired
    private BuyService buyService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/selectPage", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public BaseResult<IPage<Buy>> selectPage(
            @ApiParam(value = "页数", required = true) @PathVariable(value = "pageIndex",required = true) Integer pageIndex,
            @ApiParam(value = "每页展示数量", required = true) @PathVariable(value = "pageSize",required = true) Integer pageSize,
            @ApiParam(value = "用户信息", required = false) @RequestBody(required = false) Buy buy
    ) {
        BaseResult<IPage<Buy>> br = new BaseResult<>();
        IPage<Buy> page = buyService.selectPage(pageIndex,pageSize,buy);
        br.setData(page);
        return br;
    }

    @ApiOperation(value = "新增氪金信息", notes = "新增氪金信息")
    @RequestMapping(value = "/insertBuy", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public BaseResult<String> insertBuy(
            @ApiParam(value = "氪金信息", required = false) @RequestBody(required = false) Buy buy
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = buyService.insertBuy(buy);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "修改氪金信息", notes = "修改氪金信息")
    @RequestMapping(value = "/updateBuy", produces = Constant.PRODUCES_JSON, method = RequestMethod.PUT)
    public BaseResult<String> updateBuy(
            @ApiParam(value = "氪金信息", required = false) @RequestBody(required = false) Buy buy
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = buyService.updateBuy(buy);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "删除氪金信息", notes = "删除氪金信息")
    @RequestMapping(value = "/updateBuy", produces = Constant.PRODUCES_JSON, method = RequestMethod.DELETE)
    public BaseResult<String> updateBuy(
            @ApiParam(value = "氪金信息id", required = true) @RequestBody(required = true) Long id
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = buyService.deleteById(id);
        br.setSuccess(result == 1);
        return br;
    }

}
