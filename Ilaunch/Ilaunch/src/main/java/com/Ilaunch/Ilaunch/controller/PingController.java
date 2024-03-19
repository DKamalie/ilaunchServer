package com.Ilaunch.Ilaunch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PingController {
    @GetMapping("/api/ping")
    public String ping() {
        System.out.println("Received ping request");
        return "pong";
    }
}
