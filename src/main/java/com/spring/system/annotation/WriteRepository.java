package com.spring.system.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * MyBatis MapperScanner에서 특정 매퍼를 식별하기 위한 어노테이션 정의 이다.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WriteRepository {
}
