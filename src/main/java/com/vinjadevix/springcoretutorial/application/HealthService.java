package com.vinjadevix.springcoretutorial.application;

import com.vinjadevix.springcoretutorial.application.dto.HealthResponse;
import org.springframework.stereotype.Component;

@Component
public class HealthService implements ApplicationService<HealthResponse> {
    @Override
    public HealthResponse run() {
        return new HealthResponse("OK");
    }
}
