package com.shawnliang.data.refill.service;

import com.shawnliang.data.refill.domain.RefillOrder;
import java.util.List;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface RefillOrderService {

    /**
     * 增加一个充值订单
     * @param refillOrder 充值订单
     */
    void add(RefillOrder refillOrder);

    /**
     * 查询所有的充值订单
     * @return
     */
    List<RefillOrder> queryAll(Long userAccountId);

    /**
     * 查询充值订单
     * @param id 充值订单id
     * @return
     */
    RefillOrder queryById(Long id);

}
