package com.example.demofap.service.impl;

import com.example.demofap.dto.response.StudentCreateResponse;
import com.example.demofap.entity.Student;
import com.example.demofap.exception.NotFoundException;
import com.example.demofap.repository.StudentRepository;
import com.example.demofap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.getStudentById(id);
        if(student == null){
            throw new NotFoundException("not found student");
        }
        return student;
    }

    @Override
    public List<StudentCreateResponse> getAllStudent() {
        List<StudentCreateResponse> lstStudent = studentRepository.getAllStudent();
        if(lstStudent.size() <0){
            throw new NotFoundException("Don't have any student");
        }
        return lstStudent;
    }
}
