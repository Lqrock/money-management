package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account updateAccount(Account account) throws EntityNotFoundException {
        accountRepository.save(account);
        return account;
    }

    @Override
    public void deleteAccount(int accountId) throws EntityNotFoundException {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account getAccount(int accountId) throws EntityNotFoundException {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.get();
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }
}
