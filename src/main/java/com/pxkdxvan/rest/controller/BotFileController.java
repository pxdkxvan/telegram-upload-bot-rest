package com.pxkdxvan.rest.controller;

import com.pxkdxvan.rest.dto.BotFileData;
import com.pxkdxvan.rest.factory.ResponseEntityFactory;
import com.pxkdxvan.rest.service.BotFileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.UUID;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class BotFileController {

    private final BotFileService botFileService;

    private final ResponseEntityFactory responseEntityFactory;

    @GetMapping("/{fid}")
    public ResponseEntity<StreamingResponseBody> getFile(@PathVariable("fid") String fileId) {
        UUID sharedFileId = UUID.fromString(fileId);
        BotFileData rawFile = botFileService.load(sharedFileId);
        return responseEntityFactory.createFile(HttpStatus.OK, rawFile);
    }

}
