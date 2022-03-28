package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.mapper.LotteryDrawMapper;
import com.shawnliang.data.refill.service.LotteryDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class LotteryDrawServiceImpl implements LotteryDrawService {

    /**
     * 抽奖机会mapper组件
     */
    @Autowired
    private LotteryDrawMapper lotteryDrawMapper;

    @Override
    public void increment(Long userAccountId) {
        lotteryDrawMapper.increment(userAccountId);
    }
}
