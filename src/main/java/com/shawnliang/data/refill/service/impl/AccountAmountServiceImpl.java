package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.mapper.AccountAmountMapper;
import com.shawnliang.data.refill.service.AccountAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class AccountAmountServiceImpl implements AccountAmountService {

    /**
     * 账号金额mapper组件
     */
    @Autowired
    private AccountAmountMapper accountAmountMapper;

    @Override
    public void transfer(Long fromUserAccountId, Long toUserAccountId, Double amount) {
        accountAmountMapper.updateAmount(fromUserAccountId, -amount);
        accountAmountMapper.updateAmount(toUserAccountId, amount);
    }
}
