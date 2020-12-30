package com.yinjiansystem.yinjian.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yinjiansystem.yinjian.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description 用户 Dao层
 * @Author HCX + DT
 * @Date 2020/11/28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
