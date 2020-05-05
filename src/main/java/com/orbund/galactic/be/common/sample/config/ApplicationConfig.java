package com.orbund.galactic.be.common.sample.config;

import com.orbund.galactic.be.common.sample.api.ApiProvider;
import com.orbund.galactic.be.common.sample.filter.TenantFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.orbund.galactic.be.common.sample.config",
        "com.orbund.galactic.be.common.sample.controller",
        "com.orbund.galactic.be.common.sample.controller.onlineapplication",
        "com.orbund.galactic.be.common.sample.service.impl",
        "com.orbund.galactic.be.common.sample.service.onlineapplication.impl",
        "com.orbund.galactic.be.common.sample.mapper.onlineapplication",
        "com.orbund.galactic.be.common.sample.mapper"})
public class ApplicationConfig {

    @Bean(name = "tenantFilter")
    public FilterRegistrationBean<TenantFilter> tenantFilter() {
        FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TenantFilter());
        registrationBean.addUrlPatterns(ApiProvider.ApplicationSectionApi.ROOT_PATH + "/*");
        return registrationBean;
    }
}
