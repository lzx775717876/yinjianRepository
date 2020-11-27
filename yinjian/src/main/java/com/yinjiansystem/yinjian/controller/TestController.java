package com.yinjiansystem.yinjian.controller;

import org.springframework.web.bind.annotation.*;


/**
 * @Description 测试 Controller层
 * @Author DT
 * @Date 2020/11/27
 */
@RestController
public class TestController {

    private static final String JSON = "application/json;charset=UTF-8";

    @RequestMapping(value = "/test", produces = JSON, method = RequestMethod.GET)
    public String findApiApplyRecordById() {
        String result = "洪哥就是个鸡额";
        return result;
    }


}
