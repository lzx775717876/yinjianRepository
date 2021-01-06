package com.yinjiansystem.yinjian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yinjiansystem.yinjian.dao.LoanMapper;
import com.yinjiansystem.yinjian.pojo.Loan;
import com.yinjiansystem.yinjian.service.LoanService;
import com.yinjiansystem.yinjian.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description 拓哥贷 Service层 实现类
 * @Author DT
 * @Date 2021/1/5
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public IPage<Loan> selectPage(Integer pageNum, Integer pageSize, String userName, Integer status, String dateFrom, String dateTo) {
        IPage<Loan> loanPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Loan> query = new QueryWrapper<>();
        if (!Utils.stringEmptyOrNull(userName)){
            query.like("userName",userName);
        }
        if (status != null){
            query.eq("status",status);
        }
        if (!Utils.stringEmptyOrNull(dateFrom)){
            query.ge("dateFrom",dateFrom);
        }
        if (!Utils.stringEmptyOrNull(dateTo)){
            query.le("dateTo",dateTo);
        }
        return loanMapper.selectPage(loanPage, query);
    }

    @Override
    public int insertLoan(Loan loan){
        try{
            loan.setCreateTime(new Date());
            loan.setUpdateTime(new Date());
            return loanMapper.insert(loan);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateLoan(Loan loan) {
        try{
            loan.setUpdateTime(new Date());
            return loanMapper.updateById(loan);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return loanMapper.deleteById(id);
    }

}
