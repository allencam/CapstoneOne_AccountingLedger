package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Menus.mainMenu();
    }

    public static void getTransactions() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String header = bufferedReader.readLine();
            String input;

            while((input = bufferedReader.readLine()) != null) {
                String[] transactionArr = input.split("\\|");
                LocalDate date = LocalDate.parse(transactionArr[0]);
                LocalTime time = LocalTime.parse(transactionArr[1]);
                String description = transactionArr[2];
                String vendor = transactionArr[3];
                float amount = Float.parseFloat(transactionArr[4]);

                Transaction transaction = new Transaction(date,time,description,vendor,amount);
                transactions.add(transaction);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}