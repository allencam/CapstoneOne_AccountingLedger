package com.ps;

import java.util.Scanner;

public class Search {
    static Scanner inputScan = new Scanner(System.in);
//    ==================== By Amount ====================    \\
    public static void byAmount() {
        ReaderWriter.getTransactions();
        int min = 0;
        int max = 0;
        boolean validInput = false;
        byte creditDebit = 0;

        while (!validInput) {
            System.out.print("Search: (1) Credits or (2) Debits?: ");
            creditDebit = inputScan.nextByte();
            if(creditDebit == 1 || creditDebit == 2) {
                validInput = true;
            } else {
                System.out.println("Invalid input, try again...");
            }
        }
        System.out.print("Minimum amount: ");
        min = inputScan.nextInt();
        System.out.print("Maximum amount (0 for no maximum): ");
        max = inputScan.nextInt();
        if(creditDebit == 1){
            byAmountCredit(min,max);
        } else {
            byAmountDebit(max,min); // flipped since amounts will be negative
        }
    }
    public static void byAmountDebit(int min, int max) {
        min = -min;
        max = -max;
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            float currentTransactionAmount = currentTransaction.getAmount();
            if(min == 0) {
                if(currentTransactionAmount < max) {
                    System.out.println(Main.transactions.get(i));
                }
            } else if(currentTransactionAmount > min && currentTransactionAmount < max) {
                System.out.println(Main.transactions.get(i));
            }
        }
    }
    public static void byAmountCredit(int min, int max) {
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            float currentTransactionAmount = currentTransaction.getAmount();
            if(max == 0){
                if(currentTransactionAmount > min) {
                    System.out.println(Main.transactions.get(i));
                }
            } else if(currentTransactionAmount > min && currentTransactionAmount < max) {
                System.out.println(Main.transactions.get(i));

            }
        }
    }
}
