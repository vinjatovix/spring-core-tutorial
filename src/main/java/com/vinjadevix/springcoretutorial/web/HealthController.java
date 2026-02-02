package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import com.vinjadevix.springcoretutorial.application.dto.HealthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final ApplicationService<HealthResponse> service;

    @Autowired // Constructor Injection its recommended (used for mandatory dependencies)
    public HealthController(ApplicationService<HealthResponse> service) {
        this.service = service;
    }

    @GetMapping("/health")
    public HealthResponse run() {
        return service.run();
    }

}
