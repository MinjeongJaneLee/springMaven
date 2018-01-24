package com.spring.config.spring.web;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.spring.config.sitemesh.SiteMeshFilter;
import com.spring.config.spring.app.AppConfig;
import com.spring.config.spring.app.SqlSessionConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 웹 어플리케이션을 초기화하는 클래스 이다.
 * <ul>
 *     <li>웹 어플리케이션 설정 관련 클래스 지정</li>
 *     <li>로그 파일 위치 설정</li>
 *     <li>서블릿 필터 설정</li>
 * </ul>
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            AppConfig.class, SqlSessionConfig.class, SecurityConfig.class
        };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
            WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/"
        };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new LogbackConfigListener());
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback-${spring.profiles.active}.xml");
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] {characterEncodingFilter, new SiteMeshFilter()};
    }
}
