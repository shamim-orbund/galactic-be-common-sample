package com.orbund.galactic.be.common.sample.service.onlineapplication.impl;

import com.orbund.galactic.be.common.entities.dto.onlineapplication.ApplicationSectionDto;
import com.orbund.galactic.be.common.entities.entity.onlineapplication.ApplicationSection;
import com.orbund.galactic.be.common.entities.repository.onlineapplication.ApplicationSectionRepository;
import com.orbund.galactic.be.common.sample.mapper.onlineapplication.ApplicationSectionMapper;
import com.orbund.galactic.be.common.sample.service.onlineapplication.ApplicationSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationSectionServiceImpl implements ApplicationSectionService {

    @Autowired
    private ApplicationSectionRepository applicationSectionRepository;

    @Autowired
    private ApplicationSectionMapper applicationSectionMapper;

    @Override
    public Collection<ApplicationSectionDto> getAllApplicationSections() {
        List<ApplicationSection> applicationSections = applicationSectionRepository.findByActive((byte)1);
        if (applicationSections.isEmpty()) return Collections.EMPTY_LIST;
        return applicationSections.stream()
                .map(applicationSection -> applicationSectionMapper.applicationSectionToApplicaaaaaationSectionDto(applicationSection))
                .collect(Collectors.toList());
    }

}
