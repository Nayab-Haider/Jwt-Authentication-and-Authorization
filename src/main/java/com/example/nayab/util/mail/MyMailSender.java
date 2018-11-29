package com.example.nayab.util.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MyMailSender {

    private static final Logger log = LogManager.getLogger(MyMailSender.class);

    @Autowired
    MailTemplate mailTemplate;

    @Autowired
    private JavaMailSender emailSender;

    public boolean sendMail(MailModel mailModel){
        log.info("Entering ::: class ::: MyMailSender ::: method ::: sendMail");
        MimeMessage message=null;
        boolean mailSent=false;
        try {
            message = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(mailModel.getFrom());

            if(mailModel.getSubject()!=null && mailModel.getSubject()!="")
                mimeMessageHelper.setSubject(mailModel.getSubject());
            mimeMessageHelper.setText(mailModel.getMessage(),true);
            mimeMessageHelper.setTo(mailModel.getTo());
            if(mailModel.getMultipleTo()!=null)
            mimeMessageHelper.setTo(mailModel.getMultipleTo());
            if(mailModel.getCc()!=null)
            mimeMessageHelper.setCc(mailModel.getCc());
            if(mailModel.getBcc()!=null)
            mimeMessageHelper.setBcc(mailModel.getBcc());
            emailSender.send(message);
            mailSent=true;

        }catch (MessagingException e){

        }
        log.info("Exit ::: class ::: MyMailSender ::: method ::: sendMail");
        return mailSent    ;
    }


}
