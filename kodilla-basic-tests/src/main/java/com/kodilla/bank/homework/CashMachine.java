package com.kodilla.bank.homework;

import java.util.ArrayList;

public class CashMachine {
    private ArrayList<Integer> transactions;

    public CashMachine() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(int amount) {
        this.transactions.add(amount);
    }

    public int getBalance() {
        int balance = 0;
        for (int transaction : transactions) {
            balance += transaction;
        }
        return balance;
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    public ArrayList<Integer> getTransactions() {
        return transactions;
    }
}