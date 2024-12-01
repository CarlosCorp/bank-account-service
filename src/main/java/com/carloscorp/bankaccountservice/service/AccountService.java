package com.carloscorp.bankaccountservice.service;

import com.carloscorp.bankaccountservice.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getClientAccounts(Long clientId);
}
