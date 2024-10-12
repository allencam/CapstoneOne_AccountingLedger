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
}