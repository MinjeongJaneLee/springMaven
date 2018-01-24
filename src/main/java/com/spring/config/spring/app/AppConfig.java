package com.spring.config.spring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 스프링 어플리케이션 설정 클래스 이다.
 * <ul>
 *     <li>PropertySourcesPlaceholderConfigurer 설정</li>
 * </ul>
 */
@Configuration
@ComponentScan(basePackages = { "com.spring.web", "com.spring.system"},
        includeFilters = @ComponentScan.Filter(value = {Service.class, Repository.class, Component.class}),
        excludeFilters = @ComponentScan.Filter(value = {Controller.class}))
@PropertySource("classpath:properties/global-${spring.profiles.active}-properties.xml")
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(false);
        configurer.setIgnoreUnresolvablePlaceholders(false);
        return configurer;
    }
}
