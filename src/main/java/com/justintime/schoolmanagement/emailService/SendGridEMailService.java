package com.justintime.schoolmanagement.emailService;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SendGridEMailService implements  EmailService{
    private final SendGrid sendGrid;
//    @Value(value = "${app.sendGrid-email}")
//    private String emailAddress;

    public void sendMail(EmailDetail emailDetail) throws IOException {
        Email from = new Email("emailAddress"); // change to your verified sender
        Email toEmail = new Email(emailDetail.getToEmail());
        Content content = new Content("text/plain", emailDetail.getEmailContent());
        Mail mail = new Mail(from, emailDetail.getSubject(), toEmail, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);

            response.getStatusCode();
            response.getBody();
        } catch (IOException ex) {
            throw ex;
        }

}}
