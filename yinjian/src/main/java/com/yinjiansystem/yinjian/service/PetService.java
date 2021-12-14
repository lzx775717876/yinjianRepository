package com.yinjiansystem.yinjian.service;

import com.yinjiansystem.yinjian.pojo.Pet;

import java.util.List;

/**
 * @Description 宠物 Service层
 * @Author Zuxi Li
 * @Date 2021/12/09
 */
public interface PetService {

    /**
     * 新增宠物花销信息
     *
     * @param pet 宠物花销信息
     */
    int insertPet(Pet pet);

    /**
     * 全表查询
     */
    List<Pet> selectList();

}
