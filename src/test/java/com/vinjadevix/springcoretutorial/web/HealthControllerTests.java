package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(HealthControllerTests.TestConfig.class)
@WebMvcTest(HealthController.class)
class HealthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationService applicationService;

    @Test
    void runEndpointReturnsServiceResult() throws Exception {
        when(applicationService.run()).thenReturn("resultado esperado");

        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("resultado esperado"));
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public ApplicationService applicationService() {
            return Mockito.mock(ApplicationService.class);
        }
    }
}
