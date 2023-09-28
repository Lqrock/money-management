package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Transaction;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findById(int transactionId);
    void deleteById(int transactionId);
    List<Transaction> findByIdBetween(int firstId, int secondId, Sort sort);

    List<Transaction> findByDateBetween(LocalDate from, LocalDate to, Sort sort);
}
