package com.example.demofap.repository;

import com.example.demofap.dto.response.GroupResponse;
import com.example.demofap.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("""
            SELECT x FROM Group x
            INNER JOIN x.students x2
            WHERE x2.id = :studentId
            """)
    List<GroupResponse> findGroupByStudentId(Long studentId);

    @Query("""
            SELECT x FROM Group x
            WHERE x.id = :groupId
            """)
    Group getDetailGroup(Long groupId);
}
