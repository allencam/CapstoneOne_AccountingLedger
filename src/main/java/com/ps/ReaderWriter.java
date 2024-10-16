package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReaderWriter {
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
                Main.transactions.add(transaction);
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeTransaction(Transaction transaction) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv",true));
            bufferedWriter.write(String.format("\n%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount()
            ));
            bufferedWriter.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
