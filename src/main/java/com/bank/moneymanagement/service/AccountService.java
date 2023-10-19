package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.repository.AccountRepository;
import com.bank.moneymanagement.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {
    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StringUtils stringUtils;

    public Account addAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public String getBalance(String bankName) {
        Long amount = accountRepository.findByBankName(bankName).getCurrentBalance();
        return stringUtils.reformatAmount(amount);
    }

}
