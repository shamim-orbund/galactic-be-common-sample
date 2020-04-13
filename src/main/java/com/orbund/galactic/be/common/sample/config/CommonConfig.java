package com.orbund.galactic.be.common.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.orbund.galactic.be.common.sample.config",
        "com.orbund.galactic.be.common.sample.controller",
        "com.orbund.galactic.be.common.sample.service.impl",
        "com.orbund.galactic.be.common.sample.mapper"})
public class CommonConfig {

}
