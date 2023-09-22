package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/get/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable int transactionId) {
        Transaction transaction = transactionService.getTransaction(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/delete/{transactionId}")
    public String deleteTransaction(@PathVariable int transactionId, Model model) {
        transactionService.deleteTransaction(transactionId);
        List<Transaction> transactions = transactionService.getAllTransaction();
        model.addAttribute("transactions", transactions);
        return "show-all-transactions";
    }

    @GetMapping("/get-all")
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransaction();
        model.addAttribute("transactions", transactions);
        return "show-all-transactions";
    }

}
