/*
 * Copyright (c) 2020-2020 Gannalyo.
 */

package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gannalyo
 * @since 2020/6/11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
