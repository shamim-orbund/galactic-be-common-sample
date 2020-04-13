package com.orbund.galactic.be.common.sample.mapper;

import com.orbund.galactic.be.common.entities.dto.SampleDto;
import com.orbund.galactic.be.common.entities.entity.Sample;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SampleMapper {
    Sample sampleDtoToSample(SampleDto sampleDto);
    SampleDto sampleToSampleDto(Sample sample);
}
