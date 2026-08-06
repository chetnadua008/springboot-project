package com.first.first.controllers;
import com.first.first.entity.TeacherErrorResponse;
import com.first.first.exceptions.TeacherNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.first.first.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    List<Teacher> myTeachers;

    @PostConstruct
    public void postConstruct(){
        myTeachers=new ArrayList<>();
        myTeachers.add(new Teacher("Chetna","Dua"));
        myTeachers.add(new Teacher("Purva","Dua"));
    }


    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return myTeachers;
        //data binding - spring jakarta converts POJO into JSON by using getter methods of Teacher POJO
    }



    //ResponseEntity<Object> to send any object as response + HTTP Status Code
    @GetMapping("/teacher/{teacherId}")
    public Teacher getTeacherById(@PathVariable int teacherId){
        if(teacherId<0 || teacherId>=myTeachers.size()){
            throw new TeacherNotFoundException("Teacher with id: "+teacherId+" does not exist");
        }
        else{
            return myTeachers.get(teacherId);
        }
    }

    @ExceptionHandler
    public ResponseEntity<TeacherErrorResponse> handleTeacherNotFoundException(TeacherNotFoundException exec){
        TeacherErrorResponse error = new TeacherErrorResponse(exec.getMessage(),HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

}
