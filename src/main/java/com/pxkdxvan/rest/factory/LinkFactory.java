package com.pxkdxvan.rest.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class LinkFactory {

    @Value("${APPLICATION_PROTOCOL}://${APPLICATION_HOST}:${server.port}/email/verify")
    private String sourceUri;

    public String createVerify(String token) {
        return UriComponentsBuilder
                .fromPath(sourceUri)
                .queryParam("token", token)
                .toUriString();
    }

}
