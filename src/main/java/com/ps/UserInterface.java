package com.ps;

import com.ps.data.TransactionDaoImpl;
import com.ps.enums.MainMenuOption;
import com.ps.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class UserInterface {

    private static BasicDataSource dataSource = new BasicDataSource();
    private static TransactionDaoImpl dao = new TransactionDaoImpl(dataSource);

    static Scanner commandInput = new Scanner(System.in);
    static Scanner dataInput = new Scanner(System.in);

    public static void mainMenu(String username, String password) {
        try {
            dataSource.setUrl("jdbc:mysql://localhost:3306/ledger_db");
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            System.exit(1);
        } catch (NullPointerException e) {
            System.err.println("Credentials incorrect or not provided: " + e.getMessage());
            System.exit(1);
        }

        int mainMenuCommand;
        do {
            System.out.println("Please select among the following menu options: ");
            for (MainMenuOption option : MainMenuOption.values()) {
                System.out.printf("(%d) %s%n", option.getCode(), option.getDescription());
            }
            System.out.println("Your selection: ");
            mainMenuCommand = commandInput.nextInt();

            MainMenuOption selection = MainMenuOption.fromCode(mainMenuCommand);

            if (selection == null) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            switch (selection) {
                case ADD_DEPOSIT:
                    handleAddDeposit();
                    break;
                case MAKE_PAYMENT:
                    handleMakePayment();
                    break;
                case LEDGER:
                    ledgerMenu();
                case EXIT:
                    System.out.println("Exiting...");
                    break;
            }
        } while (mainMenuCommand != 0);
    }

    private static void handleAddDeposit() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().withNano(0);
        System.out.printf("Current date and time: %s | %s\n", date, time);

        System.out.println("Enter a description: ");
        String description = dataInput.nextLine();
        System.out.println("Enter a vendor: ");
        String vendor = dataInput.nextLine();
        System.out.println("Enter an amount: ");
        double amount = Math.abs(dataInput.nextDouble());

        dao.create(new Transaction(date,time,description,vendor,amount));
    }

    private static void handleMakePayment() {

    }

    private static void ledgerMenu() {
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
        } while (ledgerMenuCommand != 0);
    }
}