package com.first.first;

import com.first.first.dao.StudentRunner;
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


	//executes after all beans created,,,
	@Bean
	public CommandLineRunner commandLineRunner(StudentRunner studentRunner){
		return runner->{
			studentRunner.readStudent();
		};
	}
}
