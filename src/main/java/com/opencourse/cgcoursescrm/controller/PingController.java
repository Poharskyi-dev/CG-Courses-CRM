package com.opencourse.cgcoursescrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("test-link/ping")
    public String ping() {
        return "pong";
    }
}