package com.ps;

import java.util.Scanner;

public class Menus {
    static Scanner commandInput = new Scanner(System.in);

    public static void mainMenu() {
        int mainMenuCommand;
        do {
            System.out.println("""
                    Please select among the following:
                    (1) Add Deposit
                    (2) Make Payment
                    (3) Ledger...
                    
                    (0) Exit
                    """);
            System.out.print("Your selection: ");
            mainMenuCommand = commandInput.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    System.out.println("Feature in development..."); // DELETE WHEN DONE
                    //addDeposit();
                    break;
                case 2:
                    System.out.println("Feature in development..."); // DELETE WHEN DONE
                    //makePayment();
                    break;
                case 3:
                    ledgerMenu();
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (mainMenuCommand != 0);
    }

    public static void ledgerMenu() {
        int ledgerMenuCommand;
        do {
            System.out.println("""
                    ===== LEDGER MENU =====
                    Display which transactions:
                    (1) All Transactions
                    (2) Previous Month
                    (3) Year to Date
                    (4) Previous Year
                    
                    === SEARCHES ===
                    (5) Search by Vendor
                    (6) Search by Date Range
                    (7) Search by Description
                    (8) Search by Amount (range)
                    
                    (0) Back to Main Menu
                    """);
            System.out.print("Your selection: ");
            ledgerMenuCommand = commandInput.nextInt();

            switch (ledgerMenuCommand) {
                case 1:
                    ReaderWriter.getTransactions();
                    System.out.println(Main.transactions);
                    break;
                case 2:
                    //Search.previousMonth();
                    break;
                case 3:
                    //Search.yearToDate();
                    break;
                case 4:
                    //Search.previousYear();
                    break;
                case 5:
                    //Search.byVendor();
                    break;
                case 6:
                    //Search.byDateRange();
                    break;
                case 7:
                    //Search.byDescription();
                    break;
                case 8:
                    //Search.byAmount();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (ledgerMenuCommand != 0);
    }
}