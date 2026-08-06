package com.first.first.controllers;

import com.first.first.dao.StudentDAO;
import com.first.first.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentDAO studentDao;

    @Autowired
    public StudentController(StudentDAO studentDao){
        this.studentDao=studentDao;
    }

    //@PathVariable
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student = studentDao.findById(id);
        return student;
    }
}
