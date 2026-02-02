package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final ApplicationService service;

    @Autowired // Constructor Injection its recommended (used for mandatory dependencies)
    public HealthController(ApplicationService healthService) {
        this.service = healthService;
    }

    @GetMapping("/health")
    public String run() {
        return service.run();
    }

}
