package com.orbund.galactic.be.common.sample.controller;

import com.orbund.galactic.be.common.entities.dto.SampleDto;
import com.orbund.galactic.be.common.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/samples")
@SuppressWarnings("unchecked")
public class SampleController {

    private SampleService<SampleDto> sampleService;

    @Autowired
    public SampleController(SampleService<SampleDto> sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public ResponseEntity<Collection<SampleDto>> getAllSample() {
        Collection<SampleDto> sampleDtos = sampleService.getAll();
        if (sampleDtos.isEmpty()) return ResponseEntity.ok(Collections.EMPTY_LIST);
        return ResponseEntity.ok(sampleDtos);
    }

    @PostMapping
    public ResponseEntity<SampleDto> addSample(@RequestBody SampleDto sampleDto) {
        Optional<SampleDto> sampleDtoOptional = sampleService.persist(sampleDto);
        if (sampleDtoOptional.isPresent()) return ResponseEntity.status(HttpStatus.CREATED).body(sampleDtoOptional.get());
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
