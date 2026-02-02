package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.dto.CourseResponse;
import com.vinjadevix.springcoretutorial.application.CourseService;
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

@Import(CourseControllerTests.TestConfig.class)
@WebMvcTest(CourseController.class)
class CourseControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseService courseService;

    @Test
    void runEndpointReturnsServiceResult() throws Exception {
        CourseResponse response = Mockito.mock(CourseResponse.class);
        when(courseService.run()).thenReturn(response);

        mockMvc.perform(get("/programming-exercises"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        Mockito.verify(courseService).run();
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public CourseService courseService() {
            return Mockito.mock(CourseService.class);
        }
    }
}