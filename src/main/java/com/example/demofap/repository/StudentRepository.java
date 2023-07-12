package com.example.demofap.repository;

import com.example.demofap.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query("""
            select s from Student s where s.id = :id
            """)
    Student getStudentById(Long id);
}
