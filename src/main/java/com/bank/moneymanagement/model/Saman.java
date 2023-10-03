package com.bank.moneymanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "saman")
public class Saman extends Bank{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation")
    private Operation operation;

    @Column(name = "amount")
    private int amount;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Column(name = "balance")
    private int balance;

    @Column(name = "card_name")
    private String cardName;
}
