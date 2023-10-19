package com.bank.moneymanagement.repository;

import com.bank.moneymanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findAllByBankName(String bankName);
}
