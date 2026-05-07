package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Exception.StudentErrorResponse;
import com.example.SpringBoot.Exception.StudentNotFoundExecption;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if(studentId < 0 || studentId > theStudents.size()){
            throw new StudentNotFoundExecption("Invalid student id");
        }

        return theStudents.get(studentId);
    }


}
