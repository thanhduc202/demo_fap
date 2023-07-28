package com.example.demofap.service.impl;

import com.example.demofap.dto.response.GroupResponse;
import com.example.demofap.entity.Group;
import com.example.demofap.exception.NotFoundException;
import com.example.demofap.helper.TokenService;
import com.example.demofap.repository.GroupRepository;
import com.example.demofap.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public ResponseEntity<GroupResponse> findGroupByStudentId(Long studentId, String token) {
        studentId = tokenService.getIdFromToken(token);
        Group group = groupRepository.findGroupByStudentId(studentId);
        if(group.getId() == null){
            throw new NotFoundException("Student don't have group yet!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new GroupResponse(group));
    }

    @Override
    public Group getGroupDetail(Long studentId, Long groupId, String token) {
        studentId = tokenService.getIdFromToken(token);
        Group group = groupRepository.findGroupByStudentId(studentId);
        Optional<Group> groupExisted = groupRepository.findById(group.getId());
        if(groupExisted.isEmpty()){
            throw new NotFoundException("Student dont have class yet");
        }
        return groupRepository.getDetailGroup(groupId);
    }
}
