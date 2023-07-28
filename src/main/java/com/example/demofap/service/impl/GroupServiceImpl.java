package com.example.demofap.service.impl;

import com.example.demofap.dto.response.GroupResponse;
import com.example.demofap.entity.Group;
import com.example.demofap.exception.NotFoundException;
import com.example.demofap.helper.TokenService;
import com.example.demofap.repository.GroupRepository;
import com.example.demofap.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<GroupResponse> findGroupByStudentId(Long studentId, String token) {
        studentId = tokenService.getIdFromToken(token);
        Optional<Group>group = groupRepository.findById(studentId);
        if(group.isEmpty()){
            throw new NotFoundException("Student don't have group yet!");
        }
        return groupRepository.findGroupByStudentId(studentId);
    }

    @Override
    public Group getGroupDetail(Long studentId, Long groupId, String token) {
        studentId = tokenService.getIdFromToken(token);
        Optional<Group> groupExisted = groupRepository.findById(studentId);
        if(groupExisted.isEmpty()){
            throw new NotFoundException("Student don't have class yet");
        }
        return groupRepository.getDetailGroup(groupId);
    }
}
