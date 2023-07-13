package com.example.demofap.repository;

import com.example.demofap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where r.id = 2")
    Role getRoleDefault();

    @Query("""
            select r from Role r where r.roleName = :roleName
            """)
    Role findByRoleName(String roleName);
}
