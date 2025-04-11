package com.pxkdxvan.rest.factory;

import com.pxkdxvan.rest.dto.BotFileData;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public final class ResponseEntityFactory {

    private final ContentDispositionFactory contentDispositionFactory;

    public ResponseEntity<StreamingResponseBody> createFile(HttpStatus status, BotFileData fileData) {
        return ResponseEntity
                .status(status)
                .header(HttpHeaders.CONTENT_TYPE, fileData.mimeType())
                .header(HttpHeaders.CONTENT_DISPOSITION, String.valueOf(contentDispositionFactory.create(fileData.name())))
                .header(HttpHeaders.CONTENT_LENGTH, Long.toString(fileData.size()))
                .body(out -> out.write(fileData.binary()));
    }

    public <T> ResponseEntity<T> create(HttpStatus status, T body) {
        return ResponseEntity
                .status(status)
                .body(body);
    }

}
