package com.yinjiansystem.yinjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.Buy;

/**
 * @Description 氪金 Service层
 * @Author DT
 * @Date 2020/12/30
 */
public interface BuyService {
    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页展示数量
     * @param buy 用户信息
     * @return
     */
    IPage<Buy> selectPage(Integer pageNum, Integer pageSize, Buy buy);

    /**
     * 新增用户
     * @param buy 用户信息
     * @return
     */
    int insertBuy(Buy buy);

    /**
     * 修改用户
     * @param buy 用户信息
     * @return
     */
    int updateBuy(Buy buy);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteById(Long id);

}
