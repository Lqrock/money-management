package com.bank.moneymanagement.exception;

public class InvalidBankNameException extends Exception{

    public InvalidBankNameException(String title) {
        super(title);
    }
}
