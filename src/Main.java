import com.bank.accounts.*;
import com.bank.base.Account;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("          WELCOME TO SECUREJAVA BANK");
        System.out.println("=".repeat(60));

        while (true) {
            printMainMenu();
            int choice = getIntInput();

            System.out.println("\n" + "-".repeat(60));

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performOperations();
                case 3 -> viewAllAccounts();
                case 4 -> {
                    System.out.println("Thank you for using SecureJava Bank! Goodbye 👋");
                    System.out.println("=".repeat(60));
                    return;
                }
                default -> System.out.println("❌ Invalid option! Please choose 1-4.");
            }

            System.out.println("-".repeat(60));
        }
    }

    private static void printMainMenu() {
        System.out.println("\n📋 MAIN MENU");
        System.out.println("1. ➕ Create New Account");
        System.out.println("2. 💰 Perform Operations (Deposit / Withdraw / Interest)");
        System.out.println("3. 👀 View All Accounts");
        System.out.println("4. 🚪 Exit");
        System.out.print("→ Choose option: ");
    }

    private static void createAccount() {
        System.out.println("📝 CREATE NEW ACCOUNT");
        System.out.println("1. Savings Account");
        System.out.println("2. Fixed Deposit Account");
        System.out.println("3. Current Account");
        System.out.println("4. Student Account");
        System.out.print("→ Choose type: ");

        int type = getIntInput();

        System.out.print("Account Number: ");
        String num = sc.nextLine().trim();
        System.out.print("Initial Deposit ($): ");
        double bal = sc.nextDouble();
        sc.nextLine();

        Account acc = null;

        switch (type) {
            case 1 -> {
                System.out.print("Interest Rate (%): ");
                double rate = sc.nextDouble();
                sc.nextLine();
                acc = new SavingsAccount(num, bal, rate);
            }
            case 2 -> {
                System.out.print("Interest Rate (%): ");
                double rate = sc.nextDouble();
                System.out.print("Lock Period (months): ");
                int months = sc.nextInt();
                sc.nextLine();
                acc = new FixedDepositAccount(num, bal, rate, months);
            }
            case 3 -> acc = new CurrentAccount(num, bal);
            case 4 -> {
                System.out.print("School Name: ");
                String school = sc.nextLine().trim();
                acc = new StudentAccount(num, bal, school);
            }
            default -> {
                System.out.println("❌ Invalid account type!");
                return;
            }
        }

        accounts.add(acc);
        System.out.println("✅ SUCCESS: Account created!");
        
        System.out.println("\n📋 ACCOUNT DETAILS:");
        acc.displayInfo();
    }

    private static void performOperations() {
        if (accounts.isEmpty()) {
            System.out.println("❌ No accounts available. Please create an account first.");
            return;
        }

        viewAllAccounts();
        System.out.print("→ Select account number (1-" + accounts.size() + "): ");
        int index = getIntInput() - 1;

        if (index < 0 || index >= accounts.size()) {
            System.out.println("❌ Invalid selection!");
            return;
        }

        Account acc = accounts.get(index);
        String type = acc.getClass().getSimpleName();

        System.out.println("\n💰 OPERATIONS ON: " + type);
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Calculate Interest");
        System.out.print("→ Choose operation: ");

        int op = getIntInput();

        switch (op) {
            case 1 -> {
                System.out.print("Enter deposit amount: $");
                double amt = sc.nextDouble();
                sc.nextLine();
                acc.deposit(amt);
            }
            case 2 -> {
                System.out.print("Enter withdraw amount: $");
                double amt = sc.nextDouble();
                sc.nextLine();
                acc.withdraw(amt);
            }
            case 3 -> {
                double interest = acc.calculateInterest();
                if (interest == 0) {
                    System.out.println("ℹ️  This account type does not earn interest.");
                }
            }
            default -> System.out.println("❌ Invalid operation.");
        }

        System.out.println("\n📋 UPDATED ACCOUNT INFO:");
        acc.displayInfo();
    }

    private static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("ℹ️  No accounts created yet.");
            return;
        }

        System.out.println("📋 ALL ACCOUNTS (" + accounts.size() + ")");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + accounts.get(i).getClass().getSimpleName());
            accounts.get(i).displayInfo();
        }
    }

    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("❌ Please enter a valid number: ");
            sc.nextLine();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }
}