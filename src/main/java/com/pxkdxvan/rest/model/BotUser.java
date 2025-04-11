package com.pxkdxvan.rest.model;

import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bot_user")
public class BotUser {

    @Id
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private Long telegramId;

    @Column(nullable = false, unique = true)
    private String username;

    private String email;
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private Boolean verified;

    @CreationTimestamp
    private ZonedDateTime firstLogin;

}
