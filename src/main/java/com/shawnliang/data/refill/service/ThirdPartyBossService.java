package com.shawnliang.data.refill.service;

/**
 * Description : 访问第三方运营商BOSS系统service组件  .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/29
 */
public interface ThirdPartyBossService {

    /**
     * 充值流量
     * @param phoneNumber 手机号
     * @param data 流量
     */
    void refillData(String phoneNumber, Long data);

}
