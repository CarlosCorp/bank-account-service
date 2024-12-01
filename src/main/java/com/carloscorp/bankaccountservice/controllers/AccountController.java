package com.carloscorp.bankaccountservice.controllers;

import com.carloscorp.bankaccountservice.dto.AccountDto;
import com.carloscorp.bankaccountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/client/{client_id}")
    public ResponseEntity<List<AccountDto>> getClientAccounts(@PathVariable Long client_id){
        return ResponseEntity.ok(accountService.getClientAccounts(client_id));
    }
}
