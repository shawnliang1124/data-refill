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
public class DataPackage {

    /**
     * 主键
     */
    private Long id;
    /**
     * 流量套餐的售价
     */
    private Double price;
    /**
     * 流量的总额
     */
    private Long data;
    /**
     * 流量套餐的类型
     */
    private Integer type;
    /**
     * 流量套餐的说明
     */
    private String comment;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 优惠活动
     */
    private PromotionActivity promotionActivity;
    /**
     * 流量券活动
     */
    private CouponActivity couponActivity;

}
