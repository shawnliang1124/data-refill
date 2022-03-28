package com.shawnliang.data.refill.service;

import com.shawnliang.data.refill.domain.CouponActivity;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface CouponActivityService {

    /**
     * 查询流量套餐绑定的状态处于"进行中"的流量券活动
     * @return 流量券活动
     */
    CouponActivity queryByDataPackageId(Long dataPackageId);
}
