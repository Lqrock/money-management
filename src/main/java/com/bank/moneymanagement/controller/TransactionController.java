package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.exception.InvalidBankNameException;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) throws InvalidBankNameException {
        return new ResponseEntity<>(transactionService.addTransaction(transaction), HttpStatus.OK);
    }
}
