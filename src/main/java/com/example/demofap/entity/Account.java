package com.example.demofap.entity;

import com.example.demofap.dto.request.AccountInfoRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    @JsonBackReference
    private Lecturer lecturer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "account_role", joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")}
    )
    @JsonManagedReference
    private Set<Role> roles;

    public Account(AccountInfoRequest accountInfoRequest) {
        this.username = accountInfoRequest.getUsername();
        this.password = accountInfoRequest.getPassword();
    }
}
