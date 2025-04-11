package com.pxkdxvan.rest.model;

import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.Immutable;

import java.util.UUID;

@Getter
@Entity
@Immutable
@Table(name = "bot_verification")
public class BotVerification {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID token;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "bot_user_id", nullable = false)
    private BotUser botUser;

}
