package com.example.demofap.dto.response;

import com.example.demofap.entity.Account;
import com.example.demofap.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


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

    public AccountInfoResponse(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.role = account.getRoles();
        this.dob = account.getStudent().getDob().toEpochMilli();
    }
}
