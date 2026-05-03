package com.bank.accounts;

import com.bank.base.Account;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
  
        if (balance - amount >= -500) {
            balance -= amount;
            System.out.println("Withdrawn from Current Account: $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Account Type: Current Account (Overdraft allowed)");
    }
}