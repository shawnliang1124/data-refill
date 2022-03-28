package com.shawnliang.data.refill.service;

/**
 * Description :  积分service组件 .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface CreditService {

    /**
     * 增加积分
     * @param userAccountId 用户账号id
     */
    void increment(Long userAccountId, Double updatedPoint);
}
