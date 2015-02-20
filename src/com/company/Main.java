package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main  {

    /*Bank of Raph, declare Bank Class. Bank() used for all the functions that the bank provides, deposits,
     * withdrawals, transfers and bill pays. */
    private static Bank bank;

    /**
     * main method starts the program
     * @param args
     */
    public static void main(String[] args) {
	// start
        //SimpleDateFormat sdf = new SimpleDateFormat("");
        Account checking = new Account(100.00, new Date(), 319650141);
        Account savings = new Account(150.00, new Date(), 319650142);

        //open the bank
        bank = new Bank();


        //add money to accounts with timestamps for transactions.
        bank.setChecking(checking);
        bank.setSavings(savings);

        //prints out current information regarding checking and savings account
        print();

        makeDeposit(17.07, "checking");
        // --------------------------------------
        try {
            bank.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // sleeps program for 3 secs to test for timestamp issues
        makeWithdrawal(32.17, "savings");

        print();

    }

    /**
     * makedeposit() method, sends data to Bank class for deposits only
     * @param depositAmount
     * @param accountType
     */
    private static void makeDeposit(double depositAmount, String accountType){
        bank.deposit(depositAmount, accountType);
    }

    /**
     * makeWithdrawal() method within Main() class, allows for data to be sent to Bank
     * class
     * @param withdrawalAmount
     * @param accountType
     */
    private static void makeWithdrawal(double withdrawalAmount, String accountType){
        bank.withdrawal(withdrawalAmount, accountType);
    }

    /**
     * print method, prints out current information for savings and checking balance
     */
    private static void print(){
        System.out.println("Savings Balance: \t" + bank.getSavings().getBalance() +
                " at " + new Date().toString() + "\nAcct#: " +
                String.format("%.0f", bank.getSavings().getAccountNo()));
        System.out.println("Checking Balance: \t" + bank.getChecking().getBalance() +
                " at " + new Date().toString() + "\nAcct#: " +
                String.format("%.0f", bank.getChecking().getAccountNo()));
    }
}
