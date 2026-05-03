package com.bank.accounts;

import com.bank.base.Account;

public class StudentAccount extends Account {

    private String schoolName;

    public StudentAccount(String accountNumber, double initialBalance, String schoolName) {
        super(accountNumber, initialBalance);
        this.schoolName = schoolName;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 50) {
            System.out.println("Student Account: Maximum withdrawal per transaction is $50");
            return;
        }
        super.withdraw(amount);  
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Account Type: Student Account");
        System.out.println("School: " + schoolName);
    }
}