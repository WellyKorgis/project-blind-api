package com.blind.shared.api;

import com.blind.shared.domain.BaseEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper {
    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToUUID")
    BaseEntity dtoToEntity(BaseEntityDto baseDto);

    @Named("stringToUUID")
    default UUID stringToUUID(String id) {
        return UUID.fromString(id);
    }
    @Named("UUIDToString")
    default String UUIDToString(UUID id) {
        return id != null ? id.toString() : "";
    }
}
