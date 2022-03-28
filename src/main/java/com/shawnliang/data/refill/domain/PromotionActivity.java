package com.shawnliang.data.refill.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Data
public class PromotionActivity {
    /**
     * 优惠活动id
     */
    private Long id;
    /**
     * 流量套餐id
     */
    private Long dataPackageId;
    /**
     * 优惠价格
     */
    private Double discountPrice;
    /**
     * 优惠活动的开始时间
     */
    private Date startTime;
    /**
     * 优惠活动的结束时间
     */
    private Date endTime;
    /**
     * 优惠活动的状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
}
