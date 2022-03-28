package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.domain.PromotionActivity;
import com.shawnliang.data.refill.mapper.PromotionActivityMapper;
import com.shawnliang.data.refill.service.PromotionActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class PromotionActivityServiceImpl implements PromotionActivityService {


    /**
     * 优惠活动mapper组件
     */
    @Autowired
    private PromotionActivityMapper promotionActivityMapper;

    @Override
    public PromotionActivity queryByDataPackageId(Long dataPackageId) {
        return promotionActivityMapper.queryByDataPackageId(dataPackageId);
    }
}
