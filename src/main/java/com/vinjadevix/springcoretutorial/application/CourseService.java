package com.vinjadevix.springcoretutorial.application;

import com.vinjadevix.springcoretutorial.application.dto.CourseResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseService implements ApplicationService<CourseResponse> {
    @Override
    public CourseResponse run() {
        return new CourseResponse("1", "Spring Core Tutorial", "Learn the basics of Spring Core framework.");
    }

}
