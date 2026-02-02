package com.vinjadevix.springcoretutorial.application;

import org.springframework.stereotype.Component;

@Component
public class HealthService implements ApplicationService {
    @Override
    public String run() {
        return "OK";
    }
}
