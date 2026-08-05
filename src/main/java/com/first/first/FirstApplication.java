package com.first.first;

import com.first.first.entity.Student;
import com.first.first.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//auto configuration, component scanning to create spring beans
@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		return runner->{
//			createStudent(studentDao);
//			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			findAllStudents(studentDao);
//			findStudentByLastName(studentDao);
			findStudentByFirstName(studentDao);
		};
	}

	private void createMultipleStudents(StudentDAO studentDao){
		Student tempStudent1 = new Student("Jane","doe","jane@gmail.com");
		Student tempStudent2 = new Student("John","doe","john@gmail.com");

		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);

		System.out.println("Created two students with ids: "+tempStudent1.getId()+" " +tempStudent2.getId());
	}

	private void createStudent(StudentDAO studentDao){

		//create the student object
		Student student = new Student("Chetna","Dua","chetnadua36@gmail.com");

		//save the created student object into database
		studentDao.save(student);

		//display the saved student object
		System.out.println("Created New Student - "+student.toString());
	}
	private void readStudent(StudentDAO studentDao){

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

	private void findAllStudents(StudentDAO studentDao){

		List<Student> students = studentDao.findAll();
		if(students.isEmpty()) System.out.println("No records found: In student table");
		 else {
				for (Student tempStudent : students) {
				System.out.println(tempStudent.toString());
			}
		}
	}

	private void findStudentByLastName(StudentDAO studentDao){
		List<Student> students = studentDao.findByLastName("doe");

		if(students.isEmpty()) System.out.println("No records found: In student table");
		else {
			for (Student tempStudent : students) {
				System.out.println(tempStudent.toString());
			}
		}
	}
	private void findStudentByFirstName(StudentDAO studentDao){
		List<Student> student = studentDao.findByFirstName("urv");
		for (Student tempStudent : student) {
			System.out.println(tempStudent.toString());
		}
	}
}
