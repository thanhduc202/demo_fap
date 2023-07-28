package com.example.demofap.controller;


import com.example.demofap.dto.response.GroupResponse;

import com.example.demofap.entity.Group;
import com.example.demofap.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/view")
    ResponseEntity<GroupResponse> findGroupByStudentIdGetFromToken(Long studentId, @RequestHeader("Authorization") String token){
        return groupService.findGroupByStudentId(studentId,token);
    }

    @GetMapping("/detail/{groupId}")
    Group getGroupDetail(Long studentId, @PathVariable(name = "groupId") Long groupId, @RequestHeader("Authorization") String token){
        return groupService.getGroupDetail(studentId, groupId, token);
    }

}
