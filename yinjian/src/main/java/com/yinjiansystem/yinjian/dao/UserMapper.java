package com.yinjiansystem.yinjian.dao;

import com.yinjiansystem.yinjian.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @Description  Dao层
 * @Author HCX
 * @Date 2020/11/28
 */
@Mapper
public interface UserMapper {
    List<User> selectById();

}
