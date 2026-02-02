package com.vinjadevix.springcoretutorial.application;

import org.junit.jupiter.api.Test;

public class CourseServiceTests {
    @Test
    void returnsAString() {
        CourseService service = new CourseService();
        assert service.run() != null;
    }
}
