package com.shawnliang.data.refill.service.impl;

import com.shawnliang.data.refill.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public void send(String phoneNumber, String message) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("给" + phoneNumber + "发送了一条短信：" + message);
    }
}
