package com.example.demo;

import com.example.demo.service.SubTeacherService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TeacherFactory {

    @Autowired
    ApplicationContext context;

    public TeacherService getTeacherService(String teacherService) {
        if (teacherService == null) {
            return null;
        } else if (teacherService.equalsIgnoreCase("primary") || (teacherService.equalsIgnoreCase("secondary"))) {
            return context.getBean(SubTeacherService.class);
        }
        return null;
    }
}
