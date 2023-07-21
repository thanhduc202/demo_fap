package com.example.demofap.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @Column(name = "time_slot")
    private String timeSlot;

    @Column(name = "date")
    private Instant date;

    @Column(name = "room")
    private String room;

    @Column(name = "status")
    private Long status;

    @Column(name = "number_Of_Slot")
    private Long num;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @JsonBackReference
    private Group group;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    @JsonBackReference
    private Lecturer lecturer;

    @OneToMany(mappedBy = "session", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Attendance> attendances;
}
