package com.orbund.galactic.be.common.sample.mapper.onlineapplication;

import com.orbund.galactic.be.common.entities.dto.onlineapplication.ApplicationSectionDto;
import com.orbund.galactic.be.common.entities.entity.onlineapplication.ApplicationSection;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationSectionMapper {
    ApplicationSectionDto applicationSectionToApplicaaaaaationSectionDto(ApplicationSection applicationSection);
}
