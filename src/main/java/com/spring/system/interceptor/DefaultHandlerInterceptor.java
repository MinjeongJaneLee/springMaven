package com.spring.system.interceptor;

import com.spring.system.util.DateUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HandlerInterceptor 클래스 이다.
 */
public class DefaultHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("nowDate", DateUtils.getToday("yyyy년 MM월 dd일 EEE"));
        return true;
    }
}
