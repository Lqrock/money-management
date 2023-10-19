package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account addAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

}
