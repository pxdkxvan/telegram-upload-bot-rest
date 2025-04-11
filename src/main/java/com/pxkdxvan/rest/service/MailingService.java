package com.pxkdxvan.rest.service;

import com.pxkdxvan.rest.dto.MailPropertiesDTO;
import com.pxkdxvan.rest.factory.LinkFactory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class MailingService {

    private static final String DEFAULT_SUBJECT = "Account activation";
    private static final String DEFAULT_MESSAGE = "To complete the activation of your account, follow the link below:\n%s";
    private static final String DEFAULT_ENCODING = "UTF-8";

    private final JavaMailSender mailSender;
    private final LinkFactory linkFactory;

    public void send(MailPropertiesDTO mailPropertiesDTO) {
        String token = mailPropertiesDTO.token();
        String activationLink = linkFactory.createVerify(token);

        String to = mailPropertiesDTO.email();
        String message = DEFAULT_MESSAGE.formatted(activationLink);

        mailSender.send(mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, DEFAULT_ENCODING);
            helper.setTo(to);
            helper.setSubject(DEFAULT_SUBJECT);
            helper.setText(message);
        });
    }

}
