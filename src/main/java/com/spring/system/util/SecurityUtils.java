package com.spring.system.util;

import com.spring.web.common.login.vo.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 스프링 Security 관련 유틸리티 클래스 이다.
 */
public class SecurityUtils {
    public static CustomUserDetails getUserInfo() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomUserDetails) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (CustomUserDetails) authentication.getPrincipal();
        } else {
            return null;
        }

    }
}
