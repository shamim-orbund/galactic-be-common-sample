package com.orbund.galactic.be.common.sample.controller.onlineapplication;

import com.orbund.galactic.be.common.entities.dto.onlineapplication.ApplicationSectionDto;
import com.orbund.galactic.be.common.sample.api.ApiConstants;
import com.orbund.galactic.be.common.sample.api.ApiProvider;
import com.orbund.galactic.be.common.sample.service.onlineapplication.ApplicationSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping(ApiProvider.ApplicationSectionApi.ROOT_PATH)
public class ApplicationSectionController {

    @Autowired
    private ApplicationSectionService applicationSectionService;

    @GetMapping
    public ResponseEntity<Collection<ApplicationSectionDto>> getApplicationSections(
            @RequestHeader(ApiConstants.H_TENANT_NAME) String tenantName) {
        Collection<ApplicationSectionDto> applicationSectionDtos = applicationSectionService.getAllApplicationSections();
        if (applicationSectionDtos.isEmpty()) return ResponseEntity.ok().body(Collections.EMPTY_LIST);
        else return ResponseEntity.ok().body(applicationSectionDtos);
    }
}
