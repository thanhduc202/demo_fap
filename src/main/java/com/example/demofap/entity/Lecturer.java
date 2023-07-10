package com.example.demofap.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    @JsonManagedReference
    private List<Group> groups;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JsonManagedReference
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    private List<Session> sessions;
}
