package com.bank.moneymanagement.service;

import com.bank.moneymanagement.exception.InvalidBankNameException;
import com.bank.moneymanagement.facade.AccountManager;
import com.bank.moneymanagement.model.Account;
import com.bank.moneymanagement.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BalanceService {
    private static final Long MELLI_ID = 1L;
    private static final Long SAMAN_ID = 2L;

    @Autowired
    AccountManager accountManager;

    public void updateAccountBalance(String bankName, TransactionType transactionType, Long amount) throws InvalidBankNameException{
        Account account = accountManager.retrieveAccount(getBankIdBasedOnBankName(bankName));
        updateBalance(account, transactionType, amount);
        accountManager.saveAccount(account);
    }

    private void updateBalance(Account account, TransactionType transactionType, Long amount) {
        if (transactionType == TransactionType.WITHDRAWAL) {
            account.setCurrentBalance(account.getCurrentBalance() - amount);
        } else {
            account.setCurrentBalance(account.getCurrentBalance() + amount);
        }
    }

    private Long getBankIdBasedOnBankName(String bankName) throws InvalidBankNameException{
        if (bankName.equalsIgnoreCase("Melli")) {
            return MELLI_ID;
        } else if (bankName.equalsIgnoreCase("Saman")){
            return SAMAN_ID;
        } else {
            throw new InvalidBankNameException("بانکی با این نام ثبت نشده است");
        }
    }
}
