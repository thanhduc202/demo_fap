package com.example.demofap.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturer_id")
    private Long id;

    @Column(name = "lecturer_name")
    private String lecturerName;

    @Column(name = "dob")
    private Instant dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Group> groups;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Session> sessions;
}
