package com.bank.moneymanagement.controller;

import com.bank.moneymanagement.exception.InvalidBankNameException;
import com.bank.moneymanagement.model.Transaction;
import com.bank.moneymanagement.service.AccountService;
import com.bank.moneymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute("transaction") Transaction transaction, Model model) {
        transactionService.addTransaction(transaction);
        String bankName = transaction.getBankName();
        return "redirect:/transaction/getall/" + bankName;
    }

    @RequestMapping("/show-form")
    public String addTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "add-transaction";
    }

    @GetMapping("/getall/{bankName}")
    public String getAllTransactions(Model model, @PathVariable String bankName) {
        model.addAttribute("transactions", transactionService.findAllByBankName(bankName));
        model.addAttribute("currentBalance", accountService.getBalance(bankName));
        return "show-all-transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(Model model, @PathVariable Long id) {
        String bankName = transactionService.getTransaction(id).get().getBankName();
        transactionService.deleteTransaction(id);
        model.addAttribute("transactions", transactionService.findAllByBankName(bankName));
        model.addAttribute("currentBalance", accountService.getBalance(bankName));
        return "show-all-transactions";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Transaction>> getTransaction(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.getTransaction(id), HttpStatus.OK);
    }
}
