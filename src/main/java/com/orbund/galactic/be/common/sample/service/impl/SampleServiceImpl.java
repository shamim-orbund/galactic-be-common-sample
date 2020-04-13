package com.orbund.galactic.be.common.sample.service.impl;

import com.orbund.galactic.be.common.entities.dto.SampleDto;
import com.orbund.galactic.be.common.entities.entity.Sample;
import com.orbund.galactic.be.common.entities.repository.SampleRepository;
import com.orbund.galactic.be.common.sample.mapper.SampleMapper;
import com.orbund.galactic.be.common.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SampleServiceImpl implements SampleService<SampleDto> {

    private SampleRepository sampleRepository;
    private SampleMapper sampleMapper;

    @Autowired
    SampleServiceImpl(SampleRepository sampleRepository, SampleMapper sampleMapper) {
        this.sampleRepository = sampleRepository;
        this.sampleMapper = sampleMapper;
    }

    @Override
    public Collection<SampleDto> getAll() {
        List<Sample> samples = sampleRepository.findByActiveTrue();
        return samples.stream()
                .map(sample -> sampleMapper.sampleToSampleDto(sample))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SampleDto> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<SampleDto> persist(SampleDto dto) {
        return Optional.empty();
    }

    @Override
    public Optional<SampleDto> update(long id, SampleDto dto) {
        return Optional.empty();
    }

    @Override
    public boolean remove(long id) {
        return false;
    }
}
