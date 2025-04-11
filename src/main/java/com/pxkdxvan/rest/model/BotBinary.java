package com.pxkdxvan.rest.model;

import jakarta.persistence.*;

import lombok.Getter;

import org.hibernate.annotations.Immutable;

@Getter
@Entity
@Immutable
@Table(name = "bot_binary")
public class BotBinary {

    @Id
    private Long id;

    @Lob
    private byte[] data;

}
