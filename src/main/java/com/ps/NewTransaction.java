package com.ps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NewTransaction {
    static Scanner inputScan = new Scanner(System.in);

    public static void addDeposit() {
        //Display time to be recorded
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDate formattedDate = LocalDate.parse(currentDateTime.format(dateFormatter));
        LocalTime formattedTime = LocalTime.parse(currentDateTime.format(timeFormatter));

        System.out.printf("The current date & time will be recorded: %s %s\n",formattedDate,formattedTime);

        //User input
        System.out.print("Please enter a description for the deposit: ");
        String description = inputScan.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = inputScan.nextLine();
        System.out.print("Deposit amount: ");
        float amount = inputScan.nextFloat();
        Transaction transaction = new Transaction(formattedDate,formattedTime,description,vendor,amount);
        Main.transactions.add(transaction);
        // Write the transaction
        ReaderWriter.writeTransaction(transaction);

        Menus.returnToMenus();
    }

    public static void makePayment() {
        //Display time to be recorded
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDate formattedDate = LocalDate.parse(currentDateTime.format(dateFormatter));
        LocalTime formattedTime = LocalTime.parse(currentDateTime.format(timeFormatter));

        System.out.printf("The current date & time will be recorded: %s %s\n",formattedDate,formattedTime);

        //User input
        System.out.print("Please enter a description for the payment: ");
        String description = inputScan.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = inputScan.nextLine();
        System.out.print("Payment amount (do not enter a negative value): ");
        float amount = -inputScan.nextFloat();
        Transaction transaction = new Transaction(formattedDate,formattedTime,description,vendor,amount);
        Main.transactions.add(transaction);
        // Write the transaction
        ReaderWriter.writeTransaction(transaction);

        Menus.returnToMenus();
    }
}
