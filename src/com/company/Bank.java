package com.company;

import java.util.Date;

/**
 * Created by raphael on 2/18/15.
 */
public class Bank extends Thread {

    private Account checking;
    private Account savings;
    private final String CHECKING = "CHECKING";
    private final String SAVINGS = "SAVINGS";


    /*Bank class:
    *   Variables:
    *       Account
    *           Specifies what account and offers properties for said account
    *
    *   Methods:
    *       Withdrawal
    *           subtracts balance from account
    *       Deposits
    *           adds balance to account
    *       Transfers
    *           transfers balance from one account to another
    *       Payments
    *           same as transfer but for outside accounts
    **/

    public void withdrawal(double withdrawal, String accountType){
        Account checking = getChecking();
        Account savings = getSavings();
        Date timestamp = new Date();

        if (accountType.toUpperCase().equals(CHECKING)){
            checking.setBalance(checking.getBalance() - withdrawal);
            //timestamp = checking.getTimestamp();
        } else if (accountType.toUpperCase().equals(SAVINGS)){
            savings.setBalance(savings.getBalance() - withdrawal);
            //timestamp = savings.getTimestamp();
        } else{
            System.err.println("NO ACCOUNT FOUND");
        }

        System.out.println("Withdrawal made at: " + timestamp.toString() + " to Account: " + accountType.toUpperCase());
    }

    public void deposit(double deposit, String accountType){
        Account checking = getChecking();
        Account savings = getSavings();
        Date timestamp = new Date();

        if (accountType.toUpperCase().equals(CHECKING)){
            checking.setBalance(checking.getBalance() + deposit);
            //timestamp = checking.getTimestamp();
        } else if (accountType.toUpperCase().equals(SAVINGS)){
            savings.setBalance(savings.getBalance() + deposit);
            //timestamp = savings.getTimestamp();
        } else{
            System.err.println("NO ACCOUNT FOUND");
        }

        System.out.println("Deposit made at: " + timestamp.toString() + " to Account: " + accountType.toUpperCase());
    }

    public void transfer(){

    }

    public void payment(){

    }


    public Account getChecking() {
        return checking;
    }

    public void setChecking(Account checking) {
        this.checking = checking;
    }

    public Account getSavings() {
        return savings;
    }

    public void setSavings(Account savings) {
        this.savings = savings;
    }
}
