package com.ssaw.ssawconfigserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author HuSen.
 * @date 2018/11/21 17:14.
 */
@Slf4j
@RestController
public class AdminController {

    private final MultipleJGitEnvironmentRepository multipleJGitEnvironmentRepository;

    @Autowired
    public AdminController(MultipleJGitEnvironmentRepository multipleJGitEnvironmentRepository) {
        this.multipleJGitEnvironmentRepository = multipleJGitEnvironmentRepository;
    }

    @GetMapping
    private ModelAndView index() throws JsonProcessingException {
        Environment environment = multipleJGitEnvironmentRepository.findOne("app-demo", "test", "dev-husen");
        System.out.println(new ObjectMapper().writeValueAsString(environment));
        return new ModelAndView("index");
    }
}
