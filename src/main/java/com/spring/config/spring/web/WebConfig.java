package com.spring.config.spring.web;

import com.spring.system.interceptor.DefaultHandlerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 스프링 웹 MVC 설정 클래스 이다.
 * <ul>
 *     <li>ViewResolver 설정</li>
 *     <li>ResourceHandler 설정</li>
 *     <li>Interceptor 설정</li>
 * </ul>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.spring.web" },
        includeFilters = @ComponentScan.Filter(value = {Controller.class}),
        excludeFilters = @ComponentScan.Filter(value = {Service.class, Repository.class}))
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(false, new MappingJackson2JsonView());
        registry.jsp("/WEB-INF/views", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/assets/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/assets/fonts/");
        registry.addResourceHandler("/html/**").addResourceLocations("/assets/html/");
        registry.addResourceHandler("/icons/**").addResourceLocations("/assets/icons/");
        registry.addResourceHandler("/img/**").addResourceLocations("/assets/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/assets/js/");
        registry.addResourceHandler("/index.html").addResourceLocations("/index.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultHandlerInterceptor());
    }
}
