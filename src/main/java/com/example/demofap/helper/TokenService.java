package com.example.demofap.helper;

import com.example.demofap.entity.Account;
import com.example.demofap.repository.AccountRepository;
import com.example.demofap.security.Convert;
import com.example.demofap.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AccountRepository accountRepository;

    public Long getIdFromToken(String token){
        token = Convert.bearerTokenToToken(token);
        Account account = accountRepository.findByUsername(jwtUtils.extractUsername(token));
        return account.getId();
    }

}
