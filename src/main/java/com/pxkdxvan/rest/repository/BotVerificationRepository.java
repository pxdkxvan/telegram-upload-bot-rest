package com.pxkdxvan.rest.repository;

import com.pxkdxvan.rest.model.BotVerification;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotVerificationRepository extends JpaRepository<BotVerification, Long> {
    Optional<BotVerification> findByToken(UUID token);
}
