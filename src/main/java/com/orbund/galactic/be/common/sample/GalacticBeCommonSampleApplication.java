package com.orbund.galactic.be.common.sample;

import com.orbund.galactic.be.common.entities.GalacticBeCommonEntitiesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GalacticBeCommonEntitiesApplication.class)
public class GalacticBeCommonSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GalacticBeCommonSampleApplication.class, args);
    }
}
