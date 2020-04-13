package com.orbund.galactic.be.common.sample.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.orbund.galactic.be.common.sample.config",
        "com.orbund.galactic.be.common.sample.controller",
        "com.orbund.galactic.be.common.sample.service.impl",
        "com.orbund.galactic.be.common.sample.mapper"})
@EnableJpaRepositories(basePackages = {"com.orbund.galactic.be.common.entities.repository"})
@EntityScan(basePackages = {"com.orbund.galactic.be.common.entities.entity"})
public class CommonConfig {

}
