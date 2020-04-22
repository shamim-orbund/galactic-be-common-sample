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
    public Optional<SampleDto> findById(long sampleId) {
        Optional<Sample> sampleOptional = sampleRepository.findById(sampleId);
        if (sampleOptional.isPresent()) return Optional.of(sampleMapper.sampleToSampleDto(sampleOptional.get()));
        else return Optional.empty();
    }

    @Override
    public Optional<SampleDto> persist(SampleDto sampleDto) {
        Sample newSample = sampleMapper.sampleDtoToSample(sampleDto);
        return getSavedOrUpdatedSampleDto(newSample);
    }

    @Override
    public Optional<SampleDto> update(long sampleId, SampleDto sampleDto) {
        Optional<Sample> sampleOptional = sampleRepository.findById(sampleId);
        if (!sampleOptional.isPresent()) return Optional.empty();

        Sample updatingSample = sampleOptional.get();
        sampleMapper.updateSample(sampleDto, updatingSample);

        return getSavedOrUpdatedSampleDto(updatingSample);
    }

    @Override
    public boolean remove(long sampleId) {
        Optional<Sample> sampleOptional = sampleRepository.findById(sampleId);
        if (!sampleOptional.isPresent()) return false;

        Sample originalSample = sampleOptional.get();
        originalSample.setActive(false);
        Sample archivedSample = sampleRepository.save(originalSample);
        if (archivedSample == null) return false;
        else return true;

    }

    private Optional<SampleDto> getSavedOrUpdatedSampleDto(Sample sample) {
        try{
            Sample savedSample = sampleRepository.save(sample);
            if (savedSample != null) return Optional.of(sampleMapper.sampleToSampleDto(savedSample));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
