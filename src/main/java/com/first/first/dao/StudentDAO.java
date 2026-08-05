package com.first.first.dao;

import com.first.first.entity.Student;

import java.util.List;

//interface - list of methods available to run on student table in database
public interface StudentDAO {
    void save(Student newStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    List<Student> findByFirstName(String firstName);

}
