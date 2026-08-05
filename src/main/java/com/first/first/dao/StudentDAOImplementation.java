package com.first.first.dao;

import com.first.first.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//implement methods to run on student table

//component scanning , treats database exceptions as unchecked exceptions
@Repository
public class StudentDAOImplementation implements StudentDAO{
    //define field for entity manager
    EntityManager entityManager;


    //inject entitymanager using constructor injection
    public StudentDAOImplementation(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    //implement save method
    @Override
    @Transactional
    //database transaction
    public void save(Student newStudent) {
        entityManager.persist(newStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        //write custom query
        TypedQuery<Student> myQuery = entityManager.createQuery("Select s from Student s",Student.class);
        //execute query
        List<Student> resultStudents =  myQuery.getResultList();
        return resultStudents;
    }

    @Override
    public List<Student> findByLastName(String lastName){
        //write custom query
        TypedQuery <Student> myQuery = entityManager.createQuery("Select s from Student s WHERE s.lastName=:matchLastName",Student.class);
        //inject query parameters
        myQuery.setParameter("matchLastName",lastName);
        //execute query and save results
        List<Student> resultStudents = myQuery.getResultList();
        //return results
        return resultStudents;
    }

    @Override
    public List<Student> findByFirstName(String firstName){
        //create jpql query
        TypedQuery <Student> query = entityManager.createQuery("Select s from Student s WHERE s.firstName like :matchFirstName",Student.class);
        //inject parameters into query
        query.setParameter("matchFirstName","%" + firstName + "%");
        //execute query and save results
        List <Student> resultStudents = query.getResultList();
        //return results
        return resultStudents;
    }

}
