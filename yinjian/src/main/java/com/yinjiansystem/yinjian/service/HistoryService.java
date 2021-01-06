package com.yinjiansystem.yinjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.History;

/**
 * @Description 历史 Service层
 * @Author DT
 * @Date 2021/1/6
 */
public interface HistoryService {
    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页展示数量
     * @param title 用户名
     * @param dateFrom 起时间
     * @param dateTo 止时间
     */
    IPage<History> selectPage(Integer pageNum, Integer pageSize, String title, String dateFrom, String dateTo);

    /**
     * 新增氪金信息
     * @param buy 氪金信息
     */
    int insertHistory(History buy);

    /**
     * 修改氪金信息
     * @param buy 氪金信息
     */
    int updateHistory(History buy);

    /**
     * 删除氪金信息
     * @param id 氪金信息id
     */
    int deleteById(Long id);

}
