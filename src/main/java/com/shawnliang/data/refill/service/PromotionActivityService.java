package com.shawnliang.data.refill.service;

import com.shawnliang.data.refill.domain.PromotionActivity;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface PromotionActivityService {


    /**
     * 查询流量套餐绑定的状态处于"进行中"的优惠活动
     * @return 优惠活动
     */
    PromotionActivity queryByDataPackageId(Long dataPackageId);

}
