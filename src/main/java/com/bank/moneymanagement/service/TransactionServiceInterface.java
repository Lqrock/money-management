package com.bank.moneymanagement.service;

import com.bank.moneymanagement.model.Transaction;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionServiceInterface {

    Transaction addTransaction(Transaction transaction);

    Transaction editTransaction(Transaction transaction) throws EntityNotFoundException;

    void deleteTransaction(int transactionId) throws EntityNotFoundException;

    Transaction getTransaction(int transactionId) throws EntityNotFoundException;

    List<Transaction> getAllTransaction();
}
