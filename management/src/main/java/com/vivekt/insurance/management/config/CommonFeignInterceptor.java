package com.vivekt.insurance.management.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommonFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        // Content Type
        template.header("Content-Type", "application/json");

        // Accept Header
        template.header("Accept", "application/json");

        // Application Name
        template.header("X-App-Name", "MANAGEMENT-SERVICE");

        // Correlation Id (for tracing)
        template.header("X-Correlation-Id",
                UUID.randomUUID().toString());
    }
}

