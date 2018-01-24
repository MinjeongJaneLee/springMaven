package com.spring.web.mapping.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class MappingController {
    @RequestMapping(value = "/mapping/mapping.do")
    public String moveToMapping(){
        log.debug("moveToMapping");
        return "/mapping/mapping";
    }

}
