package com.yinjiansystem.yinjian.controller;

import com.yinjiansystem.yinjian.pojo.BaseResult;
import com.yinjiansystem.yinjian.pojo.Pet;
import com.yinjiansystem.yinjian.service.PetService;
import com.yinjiansystem.yinjian.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 宠物 Controller层
 * @Author Zuxi Li
 * @Date 2021/12/09
 */
@RestController
@RequestMapping("/pet")
@Api(value = "宠物模块", tags = {"宠物模块"})
public class PetController {

    @Resource
    private PetService petService;

    @ApiOperation(value = "全表查询", notes = "全表查询")
    @RequestMapping(value = "/selectList", produces = Constant.PRODUCES_JSON, method = RequestMethod.GET)
    public BaseResult<List<Pet>> selectList() {
        BaseResult<List<Pet>> br = new BaseResult<>();
        List<Pet> buys = petService.selectList();
        br.setData(buys);
        return br;
    }

    @ApiOperation(value = "新增宠物花销信息", notes = "新增宠物花销信息")
    @RequestMapping(value = "/insertPetItem", produces = Constant.PRODUCES_JSON, method = RequestMethod.POST)
    public BaseResult<String> insertPetItem(
            @ApiParam(value = "宠物花销信息") @RequestBody(required = false) Pet pet
    ) {
        BaseResult<String> br = new BaseResult<>();
        int result = petService.insertPet(pet);
        br.setSuccess(result == 1);
        return br;
    }

}
