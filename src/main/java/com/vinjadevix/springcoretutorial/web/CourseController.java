package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import com.vinjadevix.springcoretutorial.application.dto.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private ApplicationService<CourseResponse> service;

    @Autowired
    // Setter Injection (used for optional dependencies, if dependency is not provided the app can provide a default behavior)
    // @Qualifier is used to specify which bean to inject when multiple beans of the same type are present
    public void setService(@Qualifier("courseService") ApplicationService<CourseResponse> service) {
        this.service = service;
    }

    @GetMapping("/programming-exercises")
    public CourseResponse run() {
        return service.run();
    }
}
