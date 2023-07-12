package com.example.demofap.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCreateRequest {
    private String mail;
    private String password;
    private String dob;
    private String name;
    private String gender;
}
