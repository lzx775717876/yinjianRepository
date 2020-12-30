package com.yinjiansystem.yinjian.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yinjiansystem.yinjian.pojo.User;
import org.apache.ibatis.annotations.Mapper;



import java.util.List;

/**
 * @Description  Dao层
 * @Author HCX
 * @Date 2020/11/28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
