package com.first.first.dao;

import com.first.first.entity.Student;

import java.util.List;

 public interface StudentRunner {
    void deleteAllStudents();

    void deleteStudentById();

    void updateStudentById();

    void updateLastNames();

    void createMultipleStudents();

    void createStudent();
    void readStudent();

    List<Student> findAllStudents();

    void findStudentByLastName();
    void findStudentByFirstName();
}
