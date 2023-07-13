package com.example.demofap.dto.response;

import com.example.demofap.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleInsertResponse {
    private String status = "SUCCESS";
    private Long roleId;
    private String roleName;

    public RoleInsertResponse(Role role) {
        this.roleId = role.getId();
        this.roleName = role.getRoleName();
    }
}
