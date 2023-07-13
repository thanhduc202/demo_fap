package com.example.demofap.service.impl;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.example.demofap.dto.response.ResponseObject;
import com.example.demofap.dto.response.RoleInsertResponse;
import com.example.demofap.entity.Role;
import com.example.demofap.exception.NotFoundException;
import com.example.demofap.repository.RoleRepository;
import com.example.demofap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public ResponseEntity<RoleInsertResponse> insertRole(RoleInsertRequest roleInsertRequest) {
        Role role = new Role(roleInsertRequest);
        Role roleExist = roleRepository.findByRoleName(roleInsertRequest.getRoleName());
        if(roleExist !=null && !roleExist.getId().equals(role.getId())){
            throw new NotFoundException("Role name have existed");
        }
        Role result = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.OK).body(new RoleInsertResponse(result));
    }
}
