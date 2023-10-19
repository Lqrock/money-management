package com.bank.moneymanagement.facade;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountManager {

    @Autowired
    AccountRepository accountRepository;

    public Account retrieveAccount(Long bankId) {
        Optional<Account> optionalAccount = accountRepository.findById(bankId);
        return optionalAccount.get();
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
