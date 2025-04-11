package com.pxkdxvan.rest.service;

import com.pxkdxvan.rest.exception.VerificationNotFound;
import com.pxkdxvan.rest.model.BotVerification;
import com.pxkdxvan.rest.repository.BotVerificationRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class VerificationService {

    private final BotVerificationRepository botVerificationRepository;

    @Transactional
    public void verify(String token) {
        BotVerification verification = botVerificationRepository
                .findByToken(UUID.fromString(token))
                .orElseThrow(VerificationNotFound::new);

        verification
                .getBotUser()
                .setVerified(true);

        botVerificationRepository.delete(verification);
    }

}
