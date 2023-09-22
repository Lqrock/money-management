package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int transactionId);
    void deleteById(int transactionId);
}
