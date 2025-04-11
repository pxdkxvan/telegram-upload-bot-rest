package com.pxkdxvan.rest.dto;

import lombok.*;

@Builder
public record BotFileData(String name, String mimeType, Long size, byte[] binary) {}
