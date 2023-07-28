package com.example.demofap.dto.response;

import com.example.demofap.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupResponse {
    private String groupName;

    public GroupResponse(Group group) {
        this.groupName = group.getGroupName();
    }
}
