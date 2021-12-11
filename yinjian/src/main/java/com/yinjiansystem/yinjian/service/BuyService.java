package com.yinjiansystem.yinjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.Buy;

import java.util.List;

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
     * @param userName 用户名
     * @param gameName 游戏名
     * @param type 氪金类型 0-虚拟 1-实体
     * @param dateFrom 起时间
     * @param dateTo 止时间
     */
    IPage<Buy> selectPage(Integer pageNum, Integer pageSize, String userName, String gameName, Integer type, String dateFrom, String dateTo);

    /**
     * 新增氪金信息
     * @param buy 氪金信息
     */
    int insertBuy(Buy buy);

    /**
     * 修改氪金信息
     * @param buy 氪金信息
     */
    int updateBuy(Buy buy);

    /**
     * 删除氪金信息
     * @param id 氪金信息id
     */
    int deleteById(Long id);

    /**
     * 全表查询
     */
    List<Buy> selectList();

    /**
     * 获取最近氪金游戏
     */
    List<String> selectLatestGame();

    /**
     * 获取当前用户最近氪金记录
     */
    List<Buy> selectPersonalLatestBuy(String userName);

}
