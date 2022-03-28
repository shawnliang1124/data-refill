package com.shawnliang.data.refill.service;

/**
 * Description :  抽奖机会service组件 .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface LotteryDrawService {

    /**
     * 增加一次抽奖次数
     * @param userAccountId 用户账号id
     */
    void increment(Long userAccountId);

}
