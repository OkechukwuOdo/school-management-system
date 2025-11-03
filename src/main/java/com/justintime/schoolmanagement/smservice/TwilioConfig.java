package com.justintime.schoolmanagement.smservice;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

public class TwilioConfig {
//    @Value("${twilio.account-sid}")
//    private String accountSid;
//
//    @Value("${twilio.auth-token}")
//    private String authToken;

    @PostConstruct
    public void initTwilio() {
        Twilio.init("accountSid", "authToken");
    }
}
