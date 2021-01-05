package com.yinjiansystem.yinjian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yinjiansystem.yinjian.pojo.Loan;

/**
 * @Description 拓哥贷 Service层
 * @Author DT
 * @Date 2021/1/5
 */
public interface LoanService {
    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页展示数量
     * @param userName 用户名
     * @param status 贷款状态 0-借贷中 1-已归还
     * @param dateFrom 起时间
     * @param dateTo 止时间
     */
    IPage<Loan> selectPage(Integer pageNum, Integer pageSize, String userName, Integer status, String dateFrom, String dateTo);

    /**
     * 新增拓哥贷信息
     * @param loan 拓哥贷信息
     */
    int insertLoan(Loan loan);

    /**
     * 修改拓哥贷信息
     * @param loan 拓哥贷信息
     */
    int updateLoan(Loan loan);

    /**
     * 删除拓哥贷信息
     * @param id 拓哥贷信息id
     */
    int deleteById(Long id);

}
