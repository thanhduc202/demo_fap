package com.example.demofap.service.impl;

import com.example.demofap.dto.request.AccountInfoRequest;
import com.example.demofap.dto.response.AccountInfoResponse;
import com.example.demofap.dto.response.TokenResponse;
import com.example.demofap.repository.AccountRepository;
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

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

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

//    public ResponseEntity<AccountInfoResponse> register(AccountInfoRequest accountInfoRequest){
//        Account foundAcc =accountRepository.findByUsername(accountInfoRequest.getUsername());
//        if (foundAcc != null) {
//            throw new NotFoundException("Username have existed!");
//        }
//    }
}
