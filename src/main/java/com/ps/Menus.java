package com.ps;

import java.util.Scanner;

public class Menus {
    static Scanner commandInput = new Scanner(System.in);

    public static void mainMenu() {
        int mainMenuCommand;
        do {
            System.out.println("""
                    Please select among the following:
                    (1) Add Deposit (Credit)
                    (2) Make Payment (Debit)
                    (3) Ledger...
                    
                    (0) Exit
                    """);
            System.out.print("Your selection: ");
            mainMenuCommand = commandInput.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    NewTransaction.addDeposit();
                    break;
                case 2:
                    NewTransaction.makePayment();
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
                    (4) Month to Date
                    (5) Previous Year
                    
                    === SEARCHES ===
                    (6) Search by Vendor
                    (7) Search by Date Range
                    (8) Search by Description
                    (9) Search by Amount (range)
                    
                    (0) Back to Main Menu
                    """);
            System.out.print("Your selection: ");
            ledgerMenuCommand = commandInput.nextInt();

            switch (ledgerMenuCommand) {
                case 1:
                    System.out.println("(1) All transactions | (2) All Credits | (3) All Debits");
                    System.out.print("Your selection: ");
                    byte selection = commandInput.nextByte();

                    if(selection == 2) {
                        Search.allCredits();
                    } else if(selection == 3) {
                        Search.allDebits();
                    } else {
                        System.out.println(Main.transactions);
                    }
                    break;
                case 2:
                    Search.previousMonth();
                    break;
                case 3:
                    Search.yearToDate();
                    break;
                case 4:
                    Search.monthToDate();
                case 5:
                    Search.previousYear();
                    break;
                case 6:
                    Search.byVendor();
                    break;
                case 7:
                    Search.byDateRange();
                    break;
                case 8:
                    Search.byDescription();
                    break;
                case 9:
                    Search.byAmount();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (ledgerMenuCommand != 0);
    }

    public static void returnToMenus() { // Additional mini-menu to give users time to look over transactions before being prompted to make another selection
        int returnCommand;
        do {
            System.out.println("(1) Return to main menu | (2) To ledger options");
            System.out.print("Your selection: ");
            returnCommand = commandInput.nextInt();

            switch (returnCommand) {
                case 1:
                    mainMenu();
                    break;
                case 2:
                    ledgerMenu();
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (returnCommand != 0);
    }
}