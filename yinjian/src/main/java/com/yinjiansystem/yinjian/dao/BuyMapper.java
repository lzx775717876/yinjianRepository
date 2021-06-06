package com.yinjiansystem.yinjian.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yinjiansystem.yinjian.pojo.Buy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 氪金 Dao层
 * @Author DT
 * @Date 2020/12/30
 */
@Mapper
public interface BuyMapper extends BaseMapper<Buy> {
    List<String> selectLatestGame();
}
