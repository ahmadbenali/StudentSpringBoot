package com.example.SpringBoot;


import static java.lang.System.*;

import com.example.SpringBoot.DAO.StudentDAO;
import com.example.SpringBoot.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;


//THIS IS A COMMAND LINE APP NOT A WEB APP
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
		//createStudent(studentDAO);
		//ReadStudent(studentDAO);
		ListALl(studentDAO);
		};

	}

	private void ListALl(StudentDAO studentDAO) {
        List<Student> allStudent=studentDAO.findAll();
		out.println(allStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		out.println("Creating new student object...");
		Student student=new Student("ahmad","smairat","ahmad@gmail.com");

		out.println("Saving the student...");
		studentDAO.save(student);

		out.println("Saved student generated id: "+student.getId());
	}

	private void ReadStudent(StudentDAO studentDAO){
		out.println("Creating new student object...");
		Student student=new Student("ali","smairat","ahmad@gmail.com");

		out.println("Saving the student...");
		studentDAO.save(student);

		int studentId= student.getId();
		out.println("Saved student generated id: "+studentId);

		out.println("Reading the student:...");
		Student temp=studentDAO.findById(studentId);

		out.println("Found the student: "+temp);
	}

}
