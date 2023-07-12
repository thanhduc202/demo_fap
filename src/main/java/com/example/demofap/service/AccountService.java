package com.example.demofap.service;

import com.example.demofap.dto.request.AccountInfoRequest;
import com.example.demofap.dto.response.AccountInfoResponse;
import com.example.demofap.dto.response.TokenResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    List<AccountInfoResponse> findAllUser();

    ResponseEntity<TokenResponse> login(AccountInfoRequest accountInfoRequest);
}
