package com.pxkdxvan.rest.mapper;

import com.pxkdxvan.rest.dto.BotFileData;
import com.pxkdxvan.rest.model.BotFile;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BotFileMapper {
    @Mapping(target = "binary", source = "botFile.binary.data")
    BotFileData mapToRawFileData(BotFile botFile);
}
