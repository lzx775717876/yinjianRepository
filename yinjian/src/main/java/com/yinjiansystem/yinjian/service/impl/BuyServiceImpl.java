package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinjiansystem.yinjian.dao.BuyMapper;
import com.yinjiansystem.yinjian.dao.UserMapper;
import com.yinjiansystem.yinjian.pojo.Buy;
import com.yinjiansystem.yinjian.pojo.Buy;
import com.yinjiansystem.yinjian.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public IPage<Buy> selectPage(Integer pageNum, Integer pageSize, Buy buy) {
        IPage<Buy> buyPage = new Page<>(pageNum, pageSize);
        return buyMapper.selectPage(buyPage, null);
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
