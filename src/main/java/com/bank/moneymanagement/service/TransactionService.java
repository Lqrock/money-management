package com.bank.moneymanagement.service;

import com.bank.moneymanagement.exception.InvalidBankNameException;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BalanceService balanceService;


    public Transaction addTransaction(Transaction transaction) throws InvalidBankNameException {
        balanceService.updateAccountBalance(transaction.getBankName(), transaction.getTransactionType(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }

}
