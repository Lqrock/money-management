package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Operation;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


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
        if (transaction.getOperation() == Operation.WITHDRAW) {
            transaction.setBalance(previousBalance - amount);
        } else if (transaction.getOperation() == Operation.DEPOSIT) {
            transaction.setBalance(previousBalance + amount);
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

    public List<Transaction> getTransactionsByIdBetween(int from, int to) {
        return transactionRepository.findByIdBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public List<Transaction> getTransactionsByDateBetween(LocalDate from, LocalDate to) {
        return transactionRepository.findByDateBetween(from, to, Sort.by(Sort.Direction.ASC, "id"));
    }


}
