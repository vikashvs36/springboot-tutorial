package com.springBootTutorial.service;

import com.springBootTutorial.modal.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {

    public void updateAccountBalance(Account account, Double amount) {
        account.setAmount(account.getAmount() + amount);
    }

    public <T> void methodUsingGenerics(T parameter) {
        System.out.println("Inside methodUsingGenerics: " + parameter.getClass().getName());
    }

}
