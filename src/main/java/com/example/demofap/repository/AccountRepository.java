package com.example.demofap.repository;

import com.example.demofap.dto.response.AccountInfoResponse;
import com.example.demofap.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("""
            select a from Account a where a.username = :username
            """)
    Account findByUsername(String username);

    @Query("""
            select a from Account a
            """)
    List<AccountInfoResponse> findAllAccount();
}
