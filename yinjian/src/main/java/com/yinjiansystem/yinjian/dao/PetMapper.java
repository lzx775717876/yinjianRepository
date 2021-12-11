package com.yinjiansystem.yinjian.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yinjiansystem.yinjian.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 宠物 Dao层
 * @Author Zuxi Li
 * @Date 2021/12/09
 */
@Mapper
public interface PetMapper extends BaseMapper<Pet> {
}
