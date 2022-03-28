package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.mapper.CreditMapper;
import com.shawnliang.data.refill.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class CreditServiceImpl implements CreditService {

    /**
     * 积分mapper组件
     */
    @Autowired
    private CreditMapper creditMapper;

    /**
     * 增加积分
     *
     * @param userAccountId 用户账号id
     */
    @Override
    public void increment(Long userAccountId, Double updatedPoint) {
        creditMapper.increment(userAccountId, updatedPoint);
    }

}
