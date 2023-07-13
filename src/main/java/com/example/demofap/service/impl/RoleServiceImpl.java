package com.example.demofap.service.impl;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import com.example.demofap.entity.Role;
import com.example.demofap.repository.RoleRepository;
import com.example.demofap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<RoleInsertResponse> insertRole(RoleInsertRequest roleInsertRequest) {
        Role role = new Role(roleInsertRequest);
        Role result = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.OK).body(new RoleInsertResponse(result));
    }
}
