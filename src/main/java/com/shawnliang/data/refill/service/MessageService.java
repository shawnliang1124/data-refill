package com.shawnliang.data.refill.service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2022/3/28
 */
public interface MessageService {

    /**
     * 发送短信
     * @param phoneNumber 手机号码
     * @param message 短信消息
     */
    void send(String phoneNumber, String message);

}
