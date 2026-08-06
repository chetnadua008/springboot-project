package com.first.first.dao;

import com.first.first.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRunnerImpl implements StudentRunner{

    StudentDAO studentDao;

    @Autowired
    public StudentRunnerImpl(StudentDAO studentDao){
        this.studentDao=studentDao;
    }
    public void deleteAllStudents() {
        studentDao.deleteAllStudents();
    }

    public void deleteStudentById() {
        int studentId=2;
        studentDao.deleteStudentById(studentId);
    }

    public void updateStudentById() {
        Student updatedStudent = studentDao.updateStudentById(1);
        System.out.println("Updated student: "+updatedStudent.toString());
    }

    public void updateLastNames(){
        int rowsAffected = studentDao.updateLastName();
        System.out.println("Number of rows affected: "+rowsAffected);
        findAllStudents();
    }


    public void createMultipleStudents(){
        Student tempStudent1 = new Student("Jane","doe","jane@gmail.com");
        Student tempStudent2 = new Student("John","doe","john@gmail.com");

        studentDao.save(tempStudent1);
        studentDao.save(tempStudent2);

        System.out.println("Created two students with ids: "+tempStudent1.getId()+" " +tempStudent2.getId());
    }

    public void createStudent(){

        //create the student object
        Student student = new Student("Chetna","Dua","chetnadua36@gmail.com");

        //save the created student object into database
        studentDao.save(student);

        //display the saved student object
        System.out.println("Created New Student - "+student.toString());
    }
    public void readStudent(){

        //create new student
        Student student = new Student("Purva","Dua","purvadua46@gmail.com");
        //save new student
        studentDao.save(student);
        //get student id
        int id = student.getId();
        System.out.println("Saved new student with id: "+id);
        //retrive student from db using id to search
        Student searchStudent = studentDao.findById(id);
        //print the retrieved student
        System.out.println("Find by id: "+searchStudent.toString());
    }

    public List<Student> findAllStudents(){

        List<Student> students = studentDao.findAll();
        return students;
    }

    public void findStudentByLastName(){
        List<Student> students = studentDao.findByLastName("doe");

        if(students.isEmpty()) System.out.println("No records found: In student table");
        else {
            for (Student tempStudent : students) {
                System.out.println(tempStudent.toString());
            }
        }
    }
    public void findStudentByFirstName(){
        List<Student> student = studentDao.findByFirstName("urv");
        for (Student tempStudent : student) {
            System.out.println(tempStudent.toString());
        }
    }
}
