package com.example.demofap.dto.response;

import com.example.demofap.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCreateResponse {
    private String name;
    private String email;
    private String gender;
    private Long dob;

    public StudentCreateResponse(Student student) {
        this.name = student.getName();
        this.email = student.getEmail();
        this.gender = student.getGender();
        this.dob = student.getDob().toEpochMilli();
    }
}
