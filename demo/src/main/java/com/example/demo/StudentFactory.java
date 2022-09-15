package com.example.demo;

import com.example.demo.service.StudentService;
import com.example.demo.service.SubStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {

    @Autowired
    private ApplicationContext context;

    public StudentService getStudentService(String studentService) {
//
//        if (studentType == null){
//
//            return null;
//        }
//        if (studentType.equalsIgnoreCase("primary")){
//
//            return context.getBean(PrimaryStudentService.class);
//
//        } else if (studentType.equalsIgnoreCase("secondary")) {
//
//            return context.getBean(SecondaryStudentService.class);
//
//        }return null;

        if (studentService == null) {
            return null;
        } else if (studentService.equalsIgnoreCase("primary") || (studentService.equalsIgnoreCase("secondary"))) {
            return context.getBean(SubStudentService.class);
        }
        return null;
    }
}
