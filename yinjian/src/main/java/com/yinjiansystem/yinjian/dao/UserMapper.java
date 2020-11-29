package com.yinjiansystem.yinjian.dao;

import com.yinjiansystem.yinjian.pojo.User;
import org.apache.ibatis.annotations.Mapper;



import java.util.List;

/**
 * @Description  Dao层
 * @Author HCX
 * @Date 2020/11/28
 */
@Mapper
public interface UserMapper {
    /**
     * 分页查询
     * @param user
     * */
    List<User> selectById(User user);

    /**
     * 插入
     * @param user
     * */
    int insertUser(User user);

    /**
     * 更新
     * @param user
     */
    int updateUser(User user);

    /**
     * 批量删除
     * @param ids
     */
    int deleteByIds(String[] ids);

}
