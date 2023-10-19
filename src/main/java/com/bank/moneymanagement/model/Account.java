package com.bank.moneymanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * شماره کارت 16 رقمی
     **/
    @Column(name = "pan")
    private Long pan;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "current_balance")
    private Double currentBalance;

    public Account(){

    }

    public Account(Long id, Long pan, String bankName, Double currentBalance) {
        this.id = id;
        this.pan = pan;
        this.bankName = bankName;
        this.currentBalance = currentBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPan() {
        return pan;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
