package com.example.SpringBoot.Exception;

public class StudentNotFoundExecption extends RuntimeException {
    public StudentNotFoundExecption(String message) {
        super(message);
    }
}
