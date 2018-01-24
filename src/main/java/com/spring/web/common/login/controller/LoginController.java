package com.spring.web.common.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 로그인 Controller
 */
@Controller
public class LoginController {
    @RequestMapping("/common/login/login.do")
    public String moveToLogin() {
        return "/common/login/login";
    }
}
