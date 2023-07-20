package com.example.demofap.controller;

import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/view")
    ResponseEntity<ResponseObject> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Student query success", studentService.getAllStudent() )) ;
    }

}
