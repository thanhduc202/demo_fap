package com.example.demofap.service;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<RoleInsertResponse> insertRole(RoleInsertRequest roleInsertRequest);
}
