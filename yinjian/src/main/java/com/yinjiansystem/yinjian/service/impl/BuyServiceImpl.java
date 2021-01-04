package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinjiansystem.yinjian.dao.BuyMapper;
import com.yinjiansystem.yinjian.pojo.Buy;
import com.yinjiansystem.yinjian.service.BuyService;
import com.yinjiansystem.yinjian.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Description 氪金 Service层 实现类
 * @Author DT
 * @Date 2020/12/30
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;

    @Override
    public IPage<Buy> selectPage(Integer pageNum, Integer pageSize, String userName, String gameName, Integer type, String dateFrom, String dateTo) {
        IPage<Buy> buyPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Buy> query = new QueryWrapper<>();
        if (!Utils.stringEmptyOrNull(userName)){
            query.like("userName",userName);
        }
        if (!Utils.stringEmptyOrNull(gameName)){
            query.like("gameName",gameName);
        }
        if (type != null){
            query.eq("type",type);
        }
        if (!Utils.stringEmptyOrNull(dateFrom)){
            query.ge("dateFrom",dateFrom);
        }
        if (!Utils.stringEmptyOrNull(dateTo)){
            query.le("dateTo",dateTo);
        }
        return buyMapper.selectPage(buyPage, query);
    }

    @Override
    public int insertBuy(Buy buy){
        try{
            buy.setCreateTime(new Date());
            buy.setUpdateTime(new Date());
            return buyMapper.insert(buy);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBuy(Buy buy) {
        try{
            buy.setUpdateTime(new Date());
            return buyMapper.updateById(buy);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return buyMapper.deleteById(id);
    }

}
