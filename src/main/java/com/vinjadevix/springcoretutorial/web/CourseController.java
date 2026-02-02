package com.vinjadevix.springcoretutorial.web;

import com.vinjadevix.springcoretutorial.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private ApplicationService service;

    @Autowired // Setter Injection (used for optional dependencies, if dependency is not provided the app can provide a default behavior)
    public void setService(ApplicationService courseService) {
        this.service = courseService;
    }

    @GetMapping("/programming-exercises")
    public String run() {
        return service.run();
    }
}
