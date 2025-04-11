package com.pxkdxvan.rest.controller;

import com.pxkdxvan.rest.dto.MailPropertiesDTO;
import com.pxkdxvan.rest.factory.ResponseEntityFactory;
import com.pxkdxvan.rest.service.MailingService;

import com.pxkdxvan.rest.service.VerificationService;

import jakarta.validation.Valid;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class EmailController {

    private static final String VERIFICATION_SUCCESS_MESSAGE = "Account verified successfully";

    private final MailingService mailingService;
    private final VerificationService verificationService;

    private final ResponseEntityFactory responseEntityFactory;

    @PostMapping("/send")
    public void send(@Valid @RequestBody MailPropertiesDTO mailPropertiesDTO) {
        mailingService.send(mailPropertiesDTO);
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam("token") String token) {
        verificationService.verify(token);
        return responseEntityFactory.create(HttpStatus.OK, VERIFICATION_SUCCESS_MESSAGE);
    }

}
