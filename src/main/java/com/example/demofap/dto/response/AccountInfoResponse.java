package com.example.demofap.dto.response;

import com.example.demofap.entity.Account;
import com.example.demofap.entity.Role;

import com.example.demofap.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountInfoResponse {
    private String status="SUCCESS";
    private Long id;
    private String username;
    private Set<Role> role;
    private Long dob;

    public AccountInfoResponse(Student student, Account account) {
        this.id = student.getId();
        this.username = student.getName();
        this.dob = student.getDob().toEpochMilli();
        this.role = account.getRoles();

    }
}
