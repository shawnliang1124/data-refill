package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.domain.Coupon;
import com.shawnliang.data.refill.mapper.CouponMapper;
import com.shawnliang.data.refill.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class CouponServiceImpl implements CouponService {

    /**
     * 流量券mapper组件
     */
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Coupon queryByUserAccountId(Long userAccountId) {
        return couponMapper.queryByUserAccountId(userAccountId);
    }

    @Override
    public void markCouponUsed(Long id) {
        couponMapper.updateStatus(id, 2);
    }

    @Override
    public void insert(Coupon coupon) {
        couponMapper.insert(coupon);
    }
}
