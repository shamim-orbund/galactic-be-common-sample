package com.orbund.galactic.be.common.sample.filter;


import com.orbund.galactic.be.common.entities.util.TenantContextHolder;
import com.orbund.galactic.be.common.sample.api.ApiConstants;
import org.springframework.http.MediaType;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenantFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {



        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String tenantName = httpServletRequest.getHeader(ApiConstants.H_TENANT_NAME);

        if (tenantName == null) {
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"error\": \"No tenant header supplied\"}");
            response.getWriter().flush();
            TenantContextHolder.clear();
            return;
        }

        TenantContextHolder.setTenantName(tenantName);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
