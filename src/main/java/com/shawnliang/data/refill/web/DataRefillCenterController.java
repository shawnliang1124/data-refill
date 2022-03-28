package com.shawnliang.data.refill.web;

import com.shawnliang.data.refill.domain.Coupon;
import com.shawnliang.data.refill.domain.CouponActivity;
import com.shawnliang.data.refill.domain.DataPackage;
import com.shawnliang.data.refill.domain.PromotionActivity;
import com.shawnliang.data.refill.domain.RefillOrder;
import com.shawnliang.data.refill.domain.RefillRequest;
import com.shawnliang.data.refill.domain.RefillResponse;
import com.shawnliang.data.refill.service.AccountAmountService;
import com.shawnliang.data.refill.service.CouponActivityService;
import com.shawnliang.data.refill.service.CouponService;
import com.shawnliang.data.refill.service.CreditService;
import com.shawnliang.data.refill.service.DataPackageService;
import com.shawnliang.data.refill.service.LotteryDrawService;
import com.shawnliang.data.refill.service.MessageService;
import com.shawnliang.data.refill.service.PromotionActivityService;
import com.shawnliang.data.refill.service.RefillOrderService;
import com.shawnliang.data.refill.service.ThirdPartyBossService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/29
 */
@RestController
@RequestMapping("/dataRefillCenter")
public class DataRefillCenterController {

    /**
     * 流量套餐service组件
     */
    @Autowired
    private DataPackageService dataPackageService;
    /**
     * 优惠活动service组件
     */
    @Autowired
    private PromotionActivityService promotionActivityService;
    /**
     * 流量券活动service组件
     */
    @Autowired
    private CouponActivityService couponActivityService;
    /**
     * 流量券service组件
     */
    @Autowired
    private CouponService couponService;
    /**
     * 账号金额service组件
     */
    @Autowired
    private AccountAmountService accountAmountService;
    /**
     * 充值订单service组件
     */
    @Autowired
    private RefillOrderService refillOrderService;
    /**
     * 第三方运营商BOSS系统访问service组件
     */
    @Autowired
    private ThirdPartyBossService thirdPartyBossService;
    /**
     * 消息服务service组件
     */
    @Autowired
    private MessageService messageService;
    /**
     * 抽奖机会service组件
     */
    @Autowired
    private LotteryDrawService lotteryDrawService;
    /**
     * 积分service组件
     */
    @Autowired
    private CreditService creditService;

    /**
     * 查询所有的流量套餐
     * @return
     */
    @GetMapping("/dataPackages")
    public List<DataPackage> queryAllDataPackage() {
        List<DataPackage> dataPackages = new ArrayList<DataPackage>();

        try {
            dataPackages = dataPackageService.queryAll();

            if(dataPackages != null && dataPackages.size() > 0) {
                for(DataPackage dataPackage : dataPackages) {
                    PromotionActivity promotionActivity = promotionActivityService
                            .queryByDataPackageId(dataPackage.getId());
                    dataPackage.setPromotionActivity(promotionActivity);

                    CouponActivity couponActivity = couponActivityService
                            .queryByDataPackageId(dataPackage.getId());
                    dataPackage.setCouponActivity(couponActivity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataPackages;
    }

    /**
     * 查询用户账号的面额最高的流量券
     * @param userAccountId 用户账号id
     * @return 流量券
     */
    @GetMapping("/coupon/{userAccountId}")
    public Coupon queryCoupon(
            @PathVariable("userAccountId") Long userAccountId) {
        try {
            Coupon coupon = couponService.queryByUserAccountId(userAccountId);
            if(coupon != null) {
                return coupon;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Coupon();
    }

    /**
     * 为流量充值来进行支付
     * @param refillRequest 充值请求
     * @return 充值响应
     */
    @PutMapping("/payForDataRefill")
    public RefillResponse payForDataRefill(@RequestBody RefillRequest refillRequest) {
        RefillResponse refillResponse = new RefillResponse();
        refillResponse.setCode("SUCCESS");
        refillResponse.setMessage("流量充值成功");

        try {
            // 完成支付转账
            accountAmountService.transfer(refillRequest.getUserAccountId(),
                    refillRequest.getBusinessAccountId(), refillRequest.getPayAmount());
            // 创建充值订单
            refillOrderService.add(createRefillOrder(refillRequest));
            // 完成流量充值
            thirdPartyBossService.refillData(refillRequest.getPhoneNumber(),
                    refillRequest.getData());
            // 发送短信通知充值的用户
            messageService.send(refillRequest.getPhoneNumber(), "流量已经充值成功");
            // 给用户增加一次抽奖机会
            lotteryDrawService.increment(refillRequest.getUserAccountId());
            // 给用户增加充值面值5%的积分
            creditService.increment(refillRequest.getUserAccountId(),
                    (double)Math.round((refillRequest.getPayAmount() * 0.05) * 100) / 100);
            // 如果使用了流量券的话，标记使用的流量券状态为已使用
            if(refillRequest.getCoupon() != null && refillRequest.getCoupon().getId() != null) {
                couponService.markCouponUsed(refillRequest.getCoupon().getId());
            }
            // 如果要赠送流量券的话，就会插入一张流量券
            CouponActivity couponActivity = refillRequest.getDataPackage().getCouponActivity();
            if(couponActivity != null && couponActivity.getId() != null) {
                couponService.insert(createCoupon(refillRequest, couponActivity));
            }
        } catch (Exception e) {
            e.printStackTrace();
            refillResponse.setCode("FAILURE");
            refillResponse.setMessage("流量充值失败");
        }

        return refillResponse;
    }

    /**
     * 创建流量充值订单
     * @param refillRequest
     * @return
     */
    private RefillOrder createRefillOrder(RefillRequest refillRequest) {
        RefillOrder refillOrder = new RefillOrder();
        refillOrder.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        refillOrder.setUserAccountId(refillRequest.getUserAccountId());
        refillOrder.setBusinessAccountId(refillRequest.getBusinessAccountId());
        refillOrder.setBusinessName(refillRequest.getBusinessName());
        refillOrder.setAmount(refillRequest.getPayAmount());
        refillOrder.setTitle("手机流量充值");
        refillOrder.setType("通讯物流");
        refillOrder.setStatus(1);
        refillOrder.setPayType(refillRequest.getPayType());
        refillOrder.setRefillComment("给手机号码" + refillRequest.getPhoneNumber()
                + "充值" + refillRequest.getData() + "MB流量");
        refillOrder.setRefillPhoneNumber(refillRequest.getPhoneNumber());
        refillOrder.setRefillData(refillRequest.getData());
        refillOrder.setCredit((double)Math.round((refillRequest.getPayAmount() * 0.05) * 100) / 100);
        return refillOrder;
    }

    /**
     * 创建流量券实体对象
     * @param refillRequest
     * @param couponActivity
     * @return
     */
    private Coupon createCoupon(RefillRequest refillRequest,
            CouponActivity couponActivity) {
        Coupon coupon = new Coupon();
        coupon.setUserAccountId(refillRequest.getUserAccountId());
        coupon.setCouponAmount(couponActivity.getCouponAmount());
        coupon.setStatus(1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            coupon.setEndTime(sdf.parse("2019-01-01 00:00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return coupon;
    }

    /**
     * 查询用户的所有充值订单
     * @param userAccountId 用户账号id
     * @return
     */
    @GetMapping("/refillOrders/{userAccountId}")
    public List<RefillOrder> queryAllRefillOrders(
            @PathVariable("userAccountId") Long userAccountId) {
        return refillOrderService.queryAll(userAccountId);
    }

    /**
     * 查询充值订单
     * @param id 订单id
     * @return
     */
    @GetMapping("/refillOrder/{id}")
    public RefillOrder queryRefillOrder(
            @PathVariable("id") Long id) {
        return refillOrderService.queryById(id);
    }

}
