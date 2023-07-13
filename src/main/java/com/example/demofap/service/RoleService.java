package com.example.demofap.service;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import com.example.demofap.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    ResponseEntity<RoleInsertResponse> insertRole(RoleInsertRequest roleInsertRequest);
}
