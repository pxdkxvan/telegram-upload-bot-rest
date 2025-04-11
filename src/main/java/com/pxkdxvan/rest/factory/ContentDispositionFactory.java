package com.pxkdxvan.rest.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.http.ContentDisposition;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class ContentDispositionFactory {
    public ContentDisposition create(String filename) {
        return ContentDisposition
                .attachment()
                .filename(filename, StandardCharsets.UTF_8)
                .build();
    }
}
