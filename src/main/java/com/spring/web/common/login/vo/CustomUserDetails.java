package com.spring.web.common.login.vo;

import lombok.Data;

/**
 * 사용자 인증 정보
 */
@Data
public class CustomUserDetails {
    private String adminid;
    private String encodepw;
    private int useyn;
    private String adminmemo;
    private String rate;
    private String encryptPw;
    private String encryptYn;
}
