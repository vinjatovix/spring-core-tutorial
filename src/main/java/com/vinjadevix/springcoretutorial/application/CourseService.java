package com.vinjadevix.springcoretutorial.application;

import org.springframework.stereotype.Component;

@Component
public class CourseService implements ApplicationService {
    @Override
    public String run() {
        return "Write a method that sums two numbers.";
    }

}
