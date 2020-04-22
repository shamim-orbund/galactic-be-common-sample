package com.orbund.galactic.be.common.sample.mapper;

import com.orbund.galactic.be.common.entities.dto.SampleDto;
import com.orbund.galactic.be.common.entities.entity.Sample;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SampleMapper {
    Sample sampleDtoToSample(SampleDto sampleDto);
    SampleDto sampleToSampleDto(Sample sample);

    void updateSample(SampleDto sampleDto, @MappingTarget Sample sample);
}
