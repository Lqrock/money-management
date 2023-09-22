package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("get/{accountId}")
    public ResponseEntity<Account> getAccount(@RequestParam int accountId) {
        Account account = accountService.getAccount(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}
