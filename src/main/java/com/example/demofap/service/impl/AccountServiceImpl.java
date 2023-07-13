package com.example.demofap.service.impl;

import com.example.demofap.dto.request.AccountInfoRequest;
import com.example.demofap.dto.request.StudentCreateRequest;
import com.example.demofap.dto.response.AccountInfoResponse;
import com.example.demofap.dto.response.StudentCreateResponse;
import com.example.demofap.dto.response.TokenResponse;
import com.example.demofap.entity.Account;
import com.example.demofap.entity.Role;
import com.example.demofap.entity.Student;
import com.example.demofap.exception.NotFoundException;
import com.example.demofap.repository.AccountRepository;
import com.example.demofap.repository.RoleRepository;
import com.example.demofap.repository.StudentRepository;
import com.example.demofap.security.CustomUserDetailsService;
import com.example.demofap.security.JwtUtils;
import com.example.demofap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<AccountInfoResponse> findAllUser() {
        return accountRepository.findAllAccount();
    }

    @Override
    public ResponseEntity<TokenResponse> login(AccountInfoRequest accountInfoRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountInfoRequest.getUsername(), accountInfoRequest.getPassword()));
            final UserDetails userDetail = customUserDetailsService.loadUserByUsername(accountInfoRequest.getUsername());
            if (userDetail != null) {
                return ResponseEntity.ok().body(new TokenResponse("Success", "Login success !", jwtUtils.generateToken(userDetail)));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new TokenResponse("Failed", "Wrong username or password, try again", ""));
        }
        return null;
    }

    @Override
    public ResponseEntity<AccountInfoResponse> register(StudentCreateRequest studentCreateRequest, AccountInfoRequest accountInfoRequest) {
        Account foundAcc =accountRepository.findByUsername(studentCreateRequest.getName());
        if (foundAcc != null) {
            throw new NotFoundException("Username have existed!");
        }
        Role getRoleDefault = roleRepository.getRoleDefault();
        Student student = new Student(studentCreateRequest);
        student.setDob(new Date().toInstant());
        Student s = studentRepository.save(student);
        if(getRoleDefault == null){
            throw new NotFoundException("Not found role name");
        }
        Account account = new Account();
        account.setLecturer(null);
        account.setStudent(s);
        account.setUsername(studentCreateRequest.getMail());
        account.setPassword(studentCreateRequest.getPassword());
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(getRoleDefault);
        account.setRoles(roleSet);
        Account result = accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.OK).body(new AccountInfoResponse(student, result));
    }


}
