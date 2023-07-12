package com.example.demofap.entity;

import com.example.demofap.dto.request.StudentCreateRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "dob")
    private Instant dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "students")
    @JsonBackReference
    private Set<Group> groups;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private List<Attendance> attendances;

    public Student(StudentCreateRequest studentCreateRequest) {
        this.name = studentCreateRequest.getName();
        this.dob = Instant.parse(studentCreateRequest.getDob());
        this.gender = studentCreateRequest.getGender();
        this.email = studentCreateRequest.getMail();
    }
}
