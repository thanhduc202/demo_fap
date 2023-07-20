package com.example.demofap.repository;

import com.example.demofap.dto.response.StudentCreateResponse;
import com.example.demofap.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
            select s from Student s where s.id = :id
            """)
    Student getStudentById(Long id);

    @Query(
            """
            select s from Student s
            """
    )
    List<StudentCreateResponse> getAllStudent();
}
