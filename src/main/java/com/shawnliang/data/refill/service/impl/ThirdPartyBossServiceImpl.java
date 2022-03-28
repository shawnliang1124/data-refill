package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.service.ThirdPartyBossService;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/29
 */
@Service
public class ThirdPartyBossServiceImpl implements ThirdPartyBossService {

    @Override
    public void refillData(String phoneNumber, Long data) {
        try {
            Thread.sleep(500);
            System.out.println("已经完成为" + phoneNumber + "充值" + data + "MB流量");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
