package com.shawnliang.data.refill.domain;

import java.util.Date;
import lombok.Data;

/**
 * Description :  流量券活动 .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Data
public class CouponActivity {

    /**
     * 流量券活动id
     */
    private Long id;
    /**
     * 流量套餐id
     */
    private Long dataPackageId;
    /**
     * 流量券金额
     */
    private Double couponAmount;
    /**
     * 流量券活动的开始时间
     */
    private Date startTime;
    /**
     * 流量券活动的结束时间
     */
    private Date endTime;
    /**
     * 流量券活动的状态
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
