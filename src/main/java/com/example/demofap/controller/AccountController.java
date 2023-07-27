package com.example.demofap.controller;

import com.example.demofap.dto.request.AccountInfoRequest;
import com.example.demofap.dto.request.StudentCreateRequest;
import com.example.demofap.dto.response.AccountInfoResponse;
import com.example.demofap.dto.response.StudentCreateResponse;
import com.example.demofap.dto.response.TokenResponse;
import com.example.demofap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AccountInfoResponse> findAllUser(){
        return accountService.findAllUser();
    }

    @PostMapping("/auth/login")
    ResponseEntity<TokenResponse> authenticate(@RequestBody AccountInfoRequest accountInfoRequest) {
        return accountService.login(accountInfoRequest);
    }

    @PostMapping("/auth/register")
    ResponseEntity<StudentCreateResponse> register(@RequestBody StudentCreateRequest studentCreateRequest){
        return accountService.register(studentCreateRequest);
    }
}
