package com.carloscorp.bankaccountservice.repository;

import com.carloscorp.bankaccountservice.datasource.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> getAccountsByClientId(Long clientId);

    Optional<Account> getAccountByAccountNumber(String accountNumber);
}
