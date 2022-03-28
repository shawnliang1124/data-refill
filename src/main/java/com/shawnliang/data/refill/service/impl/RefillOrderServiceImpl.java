package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.domain.RefillOrder;
import com.shawnliang.data.refill.mapper.RefillOrderMapper;
import com.shawnliang.data.refill.service.RefillOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class RefillOrderServiceImpl implements RefillOrderService {

    /**
     * 充值订单mapper组件
     */
    @Autowired
    private RefillOrderMapper refillOrderMapper;

    @Override
    public void add(RefillOrder refillOrder) {
        refillOrderMapper.add(refillOrder);
    }

    @Override
    public List<RefillOrder> queryAll(Long userAccountId) {
        return refillOrderMapper.queryAll(userAccountId) ;
    }

    @Override
    public RefillOrder queryById(Long id) {
        return refillOrderMapper.queryById(id);
    }
}
