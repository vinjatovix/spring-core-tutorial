package com.vinjadevix.springcoretutorial.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthServiceTests {

    @Test
    void runReturnsOK() {
        HealthService service = new HealthService();
        assertEquals("OK", service.run());
    }
}
