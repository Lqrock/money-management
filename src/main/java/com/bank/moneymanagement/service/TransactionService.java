package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceInterface {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);

        int transactionId = transaction.getId();
        Transaction previousTransaction = transactionRepository.findById(transactionId - 1);

        int previousBalance = previousTransaction.getBalance();
        int amount = transaction.getAmount();
        System.out.println("CURRENT BALANCE: " + amount);
        if (transaction.getOperation() == Operation.WITHDRAW) {
            System.out.println("WITHDRAWING!!!");
            System.out.println(previousBalance);
            transaction.setBalance(previousBalance - amount);
            System.out.println(transaction.getBalance());
        } else if (transaction.getOperation() == Operation.DEPOSIT) {
            System.out.println("DEPOSITING!!!");
            System.out.println(previousBalance);
            transaction.setBalance(previousBalance + amount);
            System.out.println(amount);
        }
        transactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public Transaction editTransaction(Transaction transaction) throws EntityNotFoundException {
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public void deleteTransaction(int transactionId) throws EntityNotFoundException {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public Transaction getTransaction(int transactionId) throws EntityNotFoundException {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
}
