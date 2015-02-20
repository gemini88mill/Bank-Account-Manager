package com.company;

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

        //attempt for array of deposits and withdrawals
        double[] deposits = new double[100];
        double[] withdrawals = new double[100];

        for (int x = 0; x < deposits.length; x++) {
            deposits[x] = setDepositsandWithdrawals(deposits[x]);
            withdrawals[x] = setDepositsandWithdrawals(withdrawals[x]);
            //System.out.println(deposits[x] + "\t" + withdrawals[x]);
        }

        //-------------------------------------------------

        //open the bank
        bank = new Bank();


        //add money to accounts with timestamps for transactions.
        bank.setChecking(checking);
        bank.setSavings(savings);

        //prints out current information regarding checking and savings account
        print();

        for (int i = 0; i < deposits.length; i++) {

            try {
                makeDeposit(deposits[i], "checking");
                bank.sleep(500);
                makeWithdrawal(withdrawals[i], "checking");
                bank.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        print();

    }

    private static double setDepositsandWithdrawals(double deposit) {
        double randomVal = Math.random();
        double d = randomVal * 100;
        return d;
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
