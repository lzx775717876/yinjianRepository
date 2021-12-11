package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yinjiansystem.yinjian.dao.BuyMapper;
import com.yinjiansystem.yinjian.dao.PetMapper;
import com.yinjiansystem.yinjian.pojo.Buy;
import com.yinjiansystem.yinjian.pojo.Pet;
import com.yinjiansystem.yinjian.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description 宠物 Service层 实现类
 * @Author Zuxi Li
 * @Date 2021/12/09
 */
@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Pet> selectList() {
        return petMapper.selectList(new QueryWrapper<Pet>().orderByDesc("id"));
    }

    @Override
    public int insertPet(Pet pet) {
        try {
            if (pet.getCreateTime() == null) {
                pet.setCreateTime(new Date());
            }
            pet.setUpdateTime(new Date());
            return petMapper.insert(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
