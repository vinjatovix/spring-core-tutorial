package com.vinjadevix.springcoretutorial.application;

import com.vinjadevix.springcoretutorial.application.dto.CourseResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTests {

    @Test
    void returnsNonNullFields() {
        CourseService service = new CourseService();
        CourseResponse response = service.run();

        assertAll(
            () -> assertNotNull(response.id(), "id should not be null"),
            () -> assertNotNull(response.name(), "name should not be null"),
            () -> assertNotNull(response.description(), "description should not be null")
        );
    }
}