package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.OK);
    }

}
