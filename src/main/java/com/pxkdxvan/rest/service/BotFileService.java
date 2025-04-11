package com.pxkdxvan.rest.service;

import com.pxkdxvan.rest.dto.BotFileData;
import com.pxkdxvan.rest.mapper.BotFileMapper;
import com.pxkdxvan.rest.repository.BotFileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class BotFileService {

    private final BotFileRepository botFileRepository;

    private final BotFileMapper botFileMapper;

    @SneakyThrows
    @Transactional
    public BotFileData load(UUID fileId) {
        return botFileMapper.mapToRawFileData(
                botFileRepository
                        .findByShareId(fileId)
                        .orElseThrow(FileNotFoundException::new));
    }

}
