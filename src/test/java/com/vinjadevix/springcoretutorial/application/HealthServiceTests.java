// java
package com.vinjadevix.springcoretutorial.application;

import com.vinjadevix.springcoretutorial.application.dto.HealthResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HealthServiceTests {

    @Test
    void runReturnsOK() {
        HealthService service = new HealthService();
        HealthResponse response = service.run();

        assertNotNull(response, "response should not be null");
        assertEquals("OK", response.status());
    }
}