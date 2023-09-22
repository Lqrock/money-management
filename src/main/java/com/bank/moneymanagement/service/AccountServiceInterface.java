package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Account;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountServiceInterface {

    Account createAccount(Account account);

    Account updateAccount(Account account) throws EntityNotFoundException;

    void deleteAccount(int accountId) throws EntityNotFoundException;

    Account getAccount(int accountId) throws EntityNotFoundException;

    List<Account> getAllAccounts();

}
