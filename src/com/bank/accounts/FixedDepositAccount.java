package com.bank.accounts;


public final class FixedDepositAccount extends SavingsAccount {  

    private int lockPeriodMonths;

    public FixedDepositAccount(String accountNumber, double initialBalance, 
                               double interestRate, int lockPeriodMonths) {
        super(accountNumber, initialBalance, interestRate);  
        this.lockPeriodMonths = lockPeriodMonths;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Fixed Deposit before maturity!");
    }

    public void showLockPeriod() {
        System.out.println("Lock Period: " + lockPeriodMonths + " months");
    }
}