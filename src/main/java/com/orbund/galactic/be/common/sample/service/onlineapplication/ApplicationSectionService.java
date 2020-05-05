package com.orbund.galactic.be.common.sample.service.onlineapplication;

import com.orbund.galactic.be.common.entities.dto.onlineapplication.ApplicationSectionDto;

import java.util.Collection;

public interface ApplicationSectionService {
    Collection<ApplicationSectionDto> getAllApplicationSections();
}
