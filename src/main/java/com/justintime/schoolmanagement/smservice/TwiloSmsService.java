package com.justintime.schoolmanagement.smservice;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwiloSmsService implements SmsService{
//    @Value("${twilio.trial-number}")
//    private String fromNumber;

    public String sendSms(SmsRequest request) {
        Message message = Message.creator(
                new PhoneNumber(request.getTo()), // recipient
                new PhoneNumber("fromNumber"), // Twilio trial number
                request.getMessageBody()
        ).create();

        return message.getSid();
    }
}
