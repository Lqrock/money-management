package com.bank.moneymanagement.service;

import com.bank.moneymanagement.exception.InvalidBankNameException;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findAllByBankName(String bankName) {
        return transactionRepository.findAllByBankName(bankName);
    }

    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
