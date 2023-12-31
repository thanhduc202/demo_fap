package com.example.demofap.entity;

import com.example.demofap.dto.request.RoleInsertRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Long id;

    @Column(name = "roles_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<Account> accounts;

    public Role(RoleInsertRequest roleInsertRequest) {
        this.id = roleInsertRequest.getRoleId();
        this.roleName = roleInsertRequest.getRoleName();
    }
}
