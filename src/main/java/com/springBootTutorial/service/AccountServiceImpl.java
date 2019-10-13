package com.springBootTutorial.service;

import com.springBootTutorial.modal.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {

    public void updateAccountBalance(Account account, Double amount) {
        account.setAmount(account.getAmount() + amount);
    }

    public Account getAccount(String  accountNumber) {
        if (accountNumber !=null) return new Account(accountNumber, 2000.0);
        return null;
    }

    public <T> void methodUsingGenerics(T parameter) {
        System.out.println("Inside methodUsingGenerics: " + parameter.getClass().getName());
    }

    public Boolean isExistAccount(Account account) throws NullPointerException {
        if (account == null) {
            throw new NullPointerException("Not A Valid Account ");
        }
        return true;
    }

}
