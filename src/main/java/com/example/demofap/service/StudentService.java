package com.example.demofap.service;

import com.example.demofap.dto.response.StudentCreateResponse;
import com.example.demofap.entity.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id);

    List<StudentCreateResponse> getAllStudent();
}
