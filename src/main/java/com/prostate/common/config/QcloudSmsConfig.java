package com.prostate.common.config;


import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsVoicePromptSender;
import com.github.qcloudsms.SmsVoiceVerifyCodeSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QcloudSmsConfig {


    @Value("${qcloud.appid}")
    private int appid;

    @Value("${qcloud.secretkey}")
    private String secretkey;

    @Value("${qcloud.smssign}")
    private String smssign;

    @Bean(name = "smsSingleSender")
    public SmsSingleSender getSmsSingleSender() {
        //单发
        SmsSingleSender smsSingleSender = new SmsSingleSender(appid, secretkey);

        return smsSingleSender;
    }

    @Bean(name = "smsMultiSender")
    public SmsMultiSender getSmsMultiSender() {
        //群发
        SmsMultiSender smsMultiSender = new SmsMultiSender(appid, secretkey);
        return smsMultiSender;
    }

    @Bean(name = "smsVoicePromptSender")
    public SmsVoicePromptSender getSmsVoicePromptSender() {
        //语音通知
        SmsVoicePromptSender smsVoicePromptSender = new SmsVoicePromptSender(appid, secretkey);

        return smsVoicePromptSender;
    }

    @Bean(name = "smsVoiceVerifyCodeSender")
    public SmsVoiceVerifyCodeSender getSmsVoiceVerifyCodeSender() {
        //语音验证码
        SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(appid, secretkey);

        return smsVoiceVerifyCodeSender;
    }

}
