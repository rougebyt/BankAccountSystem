
# Bank Account Management System

A Java console application developed for **Mini Project #2**.  


---

## Features

- Supports multiple types of bank accounts
- Deposit, Withdraw, and Interest calculation
- Different rules for each account type
- Clean object-oriented design using inheritance

---

## How to Compile and Run

1. Open terminal in project root
2. Compile the project:

```bash
javac -d . src/com/bank/base/*.java src/com/bank/accounts/*.java src/Main.java
```

3. Run the program:

```bash
java Main
```

---

## Project Structure

```
BankAccountSystem/
├── README.md
├── LICENSE
├── .gitignore
├── src/
│   ├── com/
│   │   └── bank/
│   │       ├── base/
│   │       │   └── Account.java
│   │       └── accounts/
│   │           ├── SavingsAccount.java
│   │           ├── CurrentAccount.java
│   │           ├── FixedDepositAccount.java
│   │           └── StudentAccount.java
│   └── Main.java
```

---


Made with proper inheritance hierarchy for learning and demonstration purposes.


```