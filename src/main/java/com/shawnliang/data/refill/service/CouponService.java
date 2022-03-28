package com.shawnliang.data.refill.service;

import com.shawnliang.data.refill.domain.Coupon;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface CouponService {


    /**
     * 查询用户账号的面额最高的一张流量券
     * @param userAccountId 用户账号id
     * @return 流量券
     */
    Coupon queryByUserAccountId(Long userAccountId);

    /**
     * 将流量券标记为已使用
     * @param id 流量券id
     */
    void markCouponUsed(Long id);

    /**
     * 插入一张流量券
     * @param coupon 流量券
     */
    void insert(Coupon coupon);
}
