package com.example.SpringBoot.DAO;

import com.example.SpringBoot.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int Id);

    List<Student> findAll();
}
