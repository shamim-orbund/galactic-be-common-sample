package com.orbund.galactic.be.common.sample.service.impl;

import com.orbund.galactic.be.common.entities.dto.SampleDto;
import com.orbund.galactic.be.common.entities.repository.SampleRepository;
import com.orbund.galactic.be.common.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class SampleServiceImpl implements SampleService<SampleDto> {

    private SampleRepository sampleRepository;

    @Autowired
    SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public Collection<SampleDto> getAll() {
        return null;
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
