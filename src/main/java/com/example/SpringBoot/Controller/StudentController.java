package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel","google@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi","google@gmail.com"));
        theStudents.add(new Student("Mary", "Smith","google@gmail.com"));
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }
}
