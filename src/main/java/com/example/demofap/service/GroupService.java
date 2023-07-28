package com.example.demofap.service;

import com.example.demofap.dto.response.GroupResponse;
import com.example.demofap.entity.Group;

import java.util.List;

public interface GroupService {

    List<GroupResponse> findGroupByStudentId(Long studentId, String token);

    Group getGroupDetail(Long StudentId ,Long groupId, String token);
}
