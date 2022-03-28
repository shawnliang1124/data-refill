package com.shawnliang.data.refill.service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface AccountAmountService {


    /**
     * 转账
     * @param fromUserAccountId 从谁那儿转账
     * @param toUserAccountId 转到谁那儿去
     * @param amount 转账金额
     */
    void transfer(Long fromUserAccountId,
            Long toUserAccountId, Double amount);


}
