package com.ps;

import java.time.LocalDate;
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
        Menus.returnToMenus();
    }
    public static void byAmountDebit(int min, int max) {
        min = -min;
        max = -max;
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            float currentTransactionAmount = currentTransaction.getAmount();
            if(min == 0) {
                if(currentTransactionAmount < max) {
                    System.out.print(Main.transactions.get(i));
                }
            } else if(currentTransactionAmount > min && currentTransactionAmount < max) {
                System.out.print(Main.transactions.get(i));
            }
        }
        Menus.returnToMenus();
    }
    public static void byAmountCredit(int min, int max) {
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            float currentTransactionAmount = currentTransaction.getAmount();
            if(max == 0){
                if(currentTransactionAmount > min) {
                    System.out.print(Main.transactions.get(i));
                }
            } else if(currentTransactionAmount > min && currentTransactionAmount < max) {
                System.out.print(Main.transactions.get(i));
            }
        }
        Menus.returnToMenus();
    }
//    ==================== All Credits/Debitts ====================    \\
    public static void allCredits() {
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            if(currentTransaction.getAmount() > 0) {
                System.out.print(Main.transactions.get(i));
            }
        }
    }
    public static void allDebits() {
        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            if(currentTransaction.getAmount() < 0) {
                System.out.print(Main.transactions.get(i));
            }
        }
    }
//    ==================== By Description ====================    \\
    public static void byDescription() {
        System.out.print("Enter the description you want to search for (will accept partial matches): ");
        String descriptionToSearch = inputScan.nextLine();

        for(int i = 0; i < Main.transactions.size(); i++){
            Transaction currentTransaction = Main.transactions.get(i);

            if(currentTransaction.getDescription().toLowerCase().contains(descriptionToSearch.toLowerCase())) {
                System.out.print(Main.transactions.get(i));
            }
        }
        Menus.returnToMenus();
    }
//    ==================== By Vendor ====================    \\
    public static void byVendor() {
        System.out.print("Enter the vendor you want to search for (will accept partial matches): ");
        String vendorToSearch = inputScan.nextLine();
        float totalByVendor = 0;

        for(int i = 0; i < Main.transactions.size(); i++){
            Transaction currentTransaction = Main.transactions.get(i);

            if(currentTransaction.getVendor().toLowerCase().contains(vendorToSearch.toLowerCase())) {
                System.out.print(Main.transactions.get(i));
                totalByVendor += currentTransaction.getAmount();
            }
        }
        System.out.printf("Net profit/loss from vendor(s) shown: %.2f\n",totalByVendor);
        Menus.returnToMenus();
    }
//    ==================== Previous Month ====================    \\
    public static void previousMonth() {
        // Get the int value of last month
        int thisMonth = LocalDate.now().getMonthValue();
        int previousMonth = thisMonth - 1;
        int thisYear = LocalDate.now().getYear();
        float monthTotal = 0;

        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            int currentTransactionMonth = currentTransaction.getDate().getMonthValue();
            int currentTransactionYear = currentTransaction.getDate().getYear();

            if(currentTransactionMonth == previousMonth && currentTransactionYear == thisYear) {
                System.out.println(Main.transactions.get(i));
                monthTotal += currentTransaction.getAmount();
            }
        }
        System.out.printf("Net profit/loss for the month shown: %.2f\n",monthTotal);
        Menus.returnToMenus();
    }
//    ==================== Year To Date ====================    \\
    public static void yearToDate() {
        // Get the int value of last month
        int thisYear = LocalDate.now().getYear();
        float yearTotal = 0;

        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            int currentTransactionYear = currentTransaction.getDate().getYear();

            if(currentTransactionYear == thisYear) {
                System.out.println(Main.transactions.get(i));
                yearTotal += currentTransaction.getAmount();
            }
        }
        System.out.printf("Net profit/loss YTD: %.2f\n",yearTotal);
        Menus.returnToMenus();
    }
    public static void previousYear() {
        // Get the int value of last month
        int thisYear = LocalDate.now().getYear();
        int previousYear = thisYear - 1;
        float yearTotal = 0;

        for(int i = 0; i < Main.transactions.size(); i++) {
            Transaction currentTransaction = Main.transactions.get(i);
            int currentTransactionYear = currentTransaction.getDate().getYear();

            if(currentTransactionYear == previousYear) {
                System.out.println(Main.transactions.get(i));
                yearTotal += currentTransaction.getAmount();
            }
        }
        System.out.printf("Net profit/loss for %s: %.2f\n",previousYear, yearTotal);
        Menus.returnToMenus();
    }
}
