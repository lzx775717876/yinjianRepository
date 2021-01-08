package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinjiansystem.yinjian.dao.HistoryMapper;
import com.yinjiansystem.yinjian.pojo.History;
import com.yinjiansystem.yinjian.service.HistoryService;
import com.yinjiansystem.yinjian.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description 历史 Service层 实现类
 * @Author DT
 * @Date 2021/1/6
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public IPage<History> selectPage(Integer pageNum, Integer pageSize, String title, String dateFrom, String dateTo) {
        Page<History> historyPage = new Page<>(pageNum, pageSize);
        historyPage.setDesc("id");
        QueryWrapper<History> query = new QueryWrapper<>();
        if (!Utils.stringEmptyOrNull(title)){
            query.like("title",title);
        }
        if (!Utils.stringEmptyOrNull(dateFrom)){
            query.ge("dateFrom",dateFrom);
        }
        if (!Utils.stringEmptyOrNull(dateTo)){
            query.le("dateTo",dateTo);
        }
        return historyMapper.selectPage(historyPage, query);
    }

    @Override
    public int insertHistory(History history){
        try{
            history.setCreateTime(new Date());
            history.setUpdateTime(new Date());
            return historyMapper.insert(history);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateHistory(History history) {
        try{
            history.setUpdateTime(new Date());
            return historyMapper.updateById(history);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return historyMapper.deleteById(id);
    }

}
