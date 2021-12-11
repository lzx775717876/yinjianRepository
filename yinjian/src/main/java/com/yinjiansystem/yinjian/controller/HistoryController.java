package com.yinjiansystem.yinjian.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.History;
import com.yinjiansystem.yinjian.service.HistoryService;
import com.yinjiansystem.yinjian.utils.Constant;
import com.yinjiansystem.yinjian.validate.DateValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 历史 Controller层
 * @Author DT
 * @Date 2021/1/6
 */
@RestController
@RequestMapping("/history")
@Api(value = "伞兵历史模块", tags = { "伞兵历史模块" })
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/selectPage", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public BaseResult<IPage<History>> selectPage(
            @ApiParam(value = "页数", required = true) @RequestParam(value = "pageIndex") Integer pageIndex,
            @ApiParam(value = "每页展示数量", required = true) @RequestParam(value = "pageSize") Integer pageSize,
            @ApiParam(value = "标题") @RequestParam(value = "title",required = false) String title,
            @DateValue(format = "yyyy-mm-dd hh:mm:ss") @ApiParam(value = "起始日期 2012-12-21 00:00:00")
            @RequestParam(value = "dateFrom", required = false) String dateFrom,
            @DateValue(format = "yyyy-mm-dd hh:mm:ss") @ApiParam(value = "结束日期 2012-12-21 00:00:00")
            @RequestParam(value = "dateTo", required = false) String dateTo
    ) {
        BaseResult<IPage<History>> br = new BaseResult<>();
        IPage<History> page = historyService.selectPage(pageIndex,pageSize,title,dateFrom,dateTo);
        br.setData(page);
        return br;
    }

    @ApiOperation(value = "新增历史信息", notes = "新增历史信息")
    @RequestMapping(value = "/insertHistory", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public BaseResult<String> insertHistory(
            @ApiParam(value = "历史信息") @RequestBody(required = false) History history
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = historyService.insertHistory(history);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "修改历史信息", notes = "修改历史信息")
    @RequestMapping(value = "/updateHistory", produces = Constant.PRODUCES_JSON, method = RequestMethod.PUT)
    public BaseResult<String> updateHistory(
            @ApiParam(value = "历史信息") @RequestBody(required = false) History history
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = historyService.updateHistory(history);
        br.setSuccess(result == 1);
        return br;
    }

    @ApiOperation(value = "删除历史信息", notes = "删除历史信息")
    @RequestMapping(value = "/updateHistory", produces = Constant.PRODUCES_JSON, method = RequestMethod.DELETE)
    public BaseResult<String> updateHistory(
            @ApiParam(value = "历史信息id", required = true) @RequestParam(value = "id") Long id
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = historyService.deleteById(id);
        br.setSuccess(result == 1);
        return br;
    }

}
