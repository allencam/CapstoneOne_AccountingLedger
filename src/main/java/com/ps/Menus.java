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
                    //addDeposit();
                    break;
                case 2:
                    //makePayment();
                    break;
                case 3:
                    //ledgerMenu
                    break;
                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (mainMenuCommand != 0);
    }

}


