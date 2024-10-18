package com.ps;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        ReaderWriter.getTransactions();
        Menus.mainMenu();
    }
}