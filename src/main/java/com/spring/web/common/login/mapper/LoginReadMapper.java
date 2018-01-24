package com.spring.web.common.login.mapper;

import com.spring.system.annotation.ReadRepository;
import com.spring.web.common.login.vo.CustomUserDetails;
import org.springframework.stereotype.Repository;

/**
 * 로그인 Mapper
 */
@Repository
@ReadRepository
public interface LoginReadMapper {
    CustomUserDetails getUserDetails(String username);
}
