package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.domain.CouponActivity;
import com.shawnliang.data.refill.mapper.CouponActivityMapper;
import com.shawnliang.data.refill.service.CouponActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class CouponActivityServiceImpl implements CouponActivityService {


    /**
     * 流量券活动mapper组件
     */
    @Autowired
    private CouponActivityMapper couponActivityMapper;

    @Override
    public CouponActivity queryByDataPackageId(Long dataPackageId) {
        return couponActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
