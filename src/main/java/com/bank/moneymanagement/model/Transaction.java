package com.bank.moneymanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    TransactionType transactionType;

    @Column(name = "description")
    String description;

    @Column(name = "amount")
    Long amount;

    @Column(name = "bank_name")
    String bankName;

    @Column(name = "date")
    Date date;

    public Transaction(Long id, TransactionType transactionType, String description, Long amount, String bankName, Date date) {
        this.id = id;
        this.transactionType = transactionType;
        this.description = description;
        this.amount = amount;
        this.bankName = bankName;
        this.date = date;
    }

}
