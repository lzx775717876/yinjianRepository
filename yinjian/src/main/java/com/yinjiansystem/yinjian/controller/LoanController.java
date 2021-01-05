package com.yinjiansystem.yinjian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.Loan;
import com.yinjiansystem.yinjian.service.LoanService;
import com.yinjiansystem.yinjian.utils.Constant;
import com.yinjiansystem.yinjian.validate.DateValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 拓哥贷 Controller层
 * @Author DT
 * @Date 2021/1/5
 */
@RestController
@RequestMapping("/loan")
@Api(value = "拓哥贷模块", tags = { "拓哥贷模块" })
public class LoanController {

    @Autowired
    private LoanService loanService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/selectPage", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public BaseResult<IPage<Loan>> selectPage(
            @ApiParam(value = "页数", required = true) @RequestParam(value = "pageIndex") Integer pageIndex,
            @ApiParam(value = "每页展示数量", required = true) @RequestParam(value = "pageSize") Integer pageSize,
            @ApiParam(value = "用户名") @RequestParam(value = "userName",required = false) String userName,
            @ApiParam(value = "贷款状态 0-借贷中 1-已归还") @RequestParam(value = "status",required = false) Integer status,
            @DateValue(format = "yyyy-mm-dd hh:mm:ss") @ApiParam(value = "起始日期 2012-12-21 00:00:00")
            @RequestParam(value = "dateFrom", required = false) String dateFrom,
            @DateValue(format = "yyyy-mm-dd hh:mm:ss") @ApiParam(value = "结束日期 2012-12-21 00:00:00")
            @RequestParam(value = "dateTo", required = false) String dateTo
    ) {
        BaseResult<IPage<Loan>> br = new BaseResult<>();
        IPage<Loan> page = loanService.selectPage(pageIndex,pageSize,userName,status,dateFrom,dateTo);
        br.setData(page);
        return br;
    }

    @ApiOperation(value = "新增拓哥贷信息", notes = "新增拓哥贷信息")
    @RequestMapping(value = "/insertLoan", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public BaseResult<String> insertLoan(
            @ApiParam(value = "拓哥贷信息") @RequestBody(required = false) Loan loan
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = loanService.insertLoan(loan);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "修改拓哥贷信息", notes = "修改拓哥贷信息")
    @RequestMapping(value = "/updateLoan", produces = Constant.PRODUCES_JSON, method = RequestMethod.PUT)
    public BaseResult<String> updateLoan(
            @ApiParam(value = "拓哥贷信息") @RequestBody(required = false) Loan loan
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = loanService.updateLoan(loan);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "删除拓哥贷信息", notes = "删除拓哥贷信息")
    @RequestMapping(value = "/updateLoan", produces = Constant.PRODUCES_JSON, method = RequestMethod.DELETE)
    public BaseResult<String> updateLoan(
            @ApiParam(value = "拓哥贷信息id", required = true) @RequestParam(value = "id") Long id
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = loanService.deleteById(id);
        br.setSuccess(result == 1);
        return br;
    }

}
