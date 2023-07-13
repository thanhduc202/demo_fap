package com.example.demofap.controller;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import com.example.demofap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    ResponseEntity<RoleInsertResponse> insertRole(@RequestBody RoleInsertRequest roleInsertRequest){
        return roleService.insertRole(roleInsertRequest);
    }
}
