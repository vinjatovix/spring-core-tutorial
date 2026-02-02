
package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.dto.HealthResponse;
import com.vinjadevix.springcoretutorial.application.HealthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Import(HealthControllerTests.TestConfig.class)
@WebMvcTest(HealthController.class)
class HealthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HealthService healthService;

    @Test
    void runEndpointReturnsServiceResult() throws Exception {
        HealthResponse response = Mockito.mock(HealthResponse.class);
        when(response.status()).thenReturn("OK");
        when(healthService.run()).thenReturn(response);

        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("OK"));

        Mockito.verify(healthService).run();
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public HealthService healthService() {
            return Mockito.mock(HealthService.class);
        }
    }
}