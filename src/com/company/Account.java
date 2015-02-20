package com.company;

import java.util.Date;

/**
 * Created by raphael on 2/18/15.
 */
public class Account extends Thread {

    private double balance;
    private Date timestamp;
    private int accountNo;

    public Account(double balance, Date timestamp, int accountNo) {
        this.balance = balance;
        this.timestamp = timestamp;
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /*Class Account:
    *   Variables:
    *       Date timestamp
    *           gives Date data for process for when the transaction takes place
    *       double balance
    *           holds balance for for account*/
}
