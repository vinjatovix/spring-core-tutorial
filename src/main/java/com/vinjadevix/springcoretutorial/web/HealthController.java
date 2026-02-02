package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final ApplicationService service;

    @Autowired // Constructor Injection its recommended (used for mandatory dependencies)
    // @Qualifier is used to specify which bean to inject when multiple beans of the same type are present
    public HealthController(@Qualifier("healthService") ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String run() {
        return service.run();
    }

}
