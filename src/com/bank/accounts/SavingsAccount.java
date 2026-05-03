package com.bank.accounts;

import com.bank.base.Account;

public class SavingsAccount extends Account {
    protected double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);   
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            if (balance - amount >= 100) {   
                balance -= amount;
                System.out.println("Withdrawn from Savings: $" + amount);
            } else {
                System.out.println("Cannot withdraw. Minimum balance $100 required.");
            }
        } else {
            System.out.println("Invalid amount!");
        }
    }

    @Override
    public double calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest);
        return interest;
    }




    @Override
    public void displayInfo() {
        super.displayInfo();  
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}