package com.carloscorp.bankaccountservice.service.impl;

import com.carloscorp.bankaccountservice.datasource.Account;
import com.carloscorp.bankaccountservice.dto.AccountDto;
import com.carloscorp.bankaccountservice.repository.AccountRepository;
import com.carloscorp.bankaccountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final Environment environment;

    @Override
    public List<AccountDto> getClientAccounts(Long clientId){
        return accountRepository.getAccountsByClientId(clientId).stream()
                .map(this::buildDto)
                .collect(Collectors.toList());
    }

    private AccountDto buildDto(Account account) {
        if (account==null){
            return null;
        }
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setAccountType(account.getAccountType());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setFunds(account.getFunds());
        dto.setClientId(account.getClientId());
        dto.setCreationDate(account.getCreationDate());
        dto.setEnvironment(getEnvironmentData());

        return dto;
    }

    private String getEnvironmentData() {
        String port = environment.getProperty("local.server.port");
        String host = environment.getProperty("HOSTNAME");
        String version = "v0.0.3";
        return port + " " + version + " " + host;
    }
}
