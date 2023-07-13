package com.example.demofap.controller;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import com.example.demofap.entity.Role;
import com.example.demofap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/view")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    List<Role> getAllRole(){
        return roleService.findAll();
    }

    @PostMapping("/insert")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    ResponseEntity<RoleInsertResponse> insertRole(@RequestBody RoleInsertRequest roleInsertRequest){
        return roleService.insertRole(roleInsertRequest);
    }
}
