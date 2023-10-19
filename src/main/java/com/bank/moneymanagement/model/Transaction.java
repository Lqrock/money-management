package com.bank.moneymanagement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    TransactionType transactionType;

    @Column(name = "description")
    String description;

    @Column(name = "amount")
    Double amount;

    @Column(name = "bank_name")
    String bankName;

    @Column(name = "date")
    Date date;

    public Transaction(Long id, TransactionType transactionType, String description, Double amount, String bankName, Date date) {
        this.id = id;
        this.transactionType = transactionType;
        this.description = description;
        this.amount = amount;
        this.bankName = bankName;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
