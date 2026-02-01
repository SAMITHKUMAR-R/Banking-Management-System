package com.bank.management;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { 
        balance += amount; 
        System.out.println("Amount deposited successfully!");
    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void display() {
        System.out.println("Account No: " + accountNumber + ", Name: " + name + ", Balance: " + balance);
    }
}

public class BankingManagementSystem {
	
	static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		
		 while(true) {
	            System.out.println("\n--- Banking Management System ---");
	            System.out.println("1. Create Account");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. View Accounts");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            switch(choice) {
	                case 1: createAccount(); break;
	                case 2: deposit(); break;
	                case 3: withdraw(); break;
	                case 4: viewAccounts(); break;
	                case 5: System.exit(0);
	                default: System.out.println("Invalid choice!");
	            }
	        }
	    }

	    // Create a new account
	    static void createAccount() {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();
	        sc.nextLine(); // consume newline
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Initial Balance: ");
	        double balance = sc.nextDouble();

	        accounts.add(new Account(accNo, name, balance));
	        System.out.println("Account created successfully!");
	    }

	    // Deposit money
	    static void deposit() {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();
	        Account acc = findAccount(accNo);
	        if(acc != null) {
	            System.out.print("Enter amount to deposit: ");
	            double amount = sc.nextDouble();
	            acc.deposit(amount);
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    // Withdraw money
	    static void withdraw() {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();
	        Account acc = findAccount(accNo);
	        if(acc != null) {
	            System.out.print("Enter amount to withdraw: ");
	            double amount = sc.nextDouble();
	            acc.withdraw(amount);
	        } else {
	            System.out.println("Account not found!");
	        }
	    }

	    // View all accounts
	    static void viewAccounts() {
	        if(accounts.isEmpty()) {
	            System.out.println("No accounts available.");
	        } else {
	            for(Account acc : accounts) {
	                acc.display();
	            }
	        }
	    }

	    // Find account by account number
	    static Account findAccount(int accNo) {
	        for(Account acc : accounts) {
	            if(acc.getAccountNumber() == accNo) return acc;
	        }
	        return null;
	    }
	}
	

		
