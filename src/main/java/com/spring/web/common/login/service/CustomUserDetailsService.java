package com.spring.web.common.login.service;

import com.spring.system.util.CommonUtils;
import com.spring.web.common.login.mapper.LoginReadMapper;
import com.spring.web.common.login.vo.CustomUserDetails;
import com.spring.web.common.login.vo.UserPrincipal;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 사용자 인증 정보를 조회 Service
 */
@Service
@Data
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private static final List<GrantedAuthority> ADMIN_DEFAULT_AUTHORITIES = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
    @Autowired
    private LoginReadMapper loginReadMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username: {}", username);
        CustomUserDetails admin = loginReadMapper.getUserDetails(username);
        if (CommonUtils.isBlank(admin)) {
            throw new UsernameNotFoundException("User not found.");
        }
        log.debug(admin.getEncryptPw());

        // @formatter:off
            return UserPrincipal.builder()
                    .username(admin.getAdminid())
                    .password(admin.getEncryptPw())
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .object(admin)
                    .authorities(ADMIN_DEFAULT_AUTHORITIES)
                .build();
            // @formatter:on
    }
}
