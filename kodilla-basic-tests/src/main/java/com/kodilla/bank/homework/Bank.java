package com.kodilla.bank.homework;

import java.util.ArrayList;

public class Bank {
    private ArrayList<CashMachine> cashMachines;

    public Bank() {
        this.cashMachines = new ArrayList<>();
    }

    public void addCashMachine(CashMachine cashMachine) {
        this.cashMachines.add(cashMachine);
    }

    public int getTotalBalance() {
        int totalBalance = 0;
        for (CashMachine cashMachine : cashMachines) {
            totalBalance += cashMachine.getBalance();
        }
        return totalBalance;
    }

    public int getTotalWithdrawals() {
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            for (int transaction : cashMachine.getTransactions()) {
                if (transaction < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getTotalDeposits() {
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            for (int transaction : cashMachine.getTransactions()) {
                if (transaction > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public double getAverageWithdrawal() {
        int totalWithdrawal = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            for (int transaction : cashMachine.getTransactions()) {
                if (transaction < 0) {
                    totalWithdrawal += transaction;
                    count++;
                }
            }
        }
        return count == 0 ? 0 : (double) totalWithdrawal / count;
    }

    public double getAverageDeposit() {
        int totalDeposit = 0;
        int count = 0;
        for (CashMachine cashMachine : cashMachines) {
            for (int transaction : cashMachine.getTransactions()) {
                if (transaction > 0) {
                    totalDeposit += transaction;
                    count++;
                }
            }
        }
        return count == 0 ? 0 : (double) totalDeposit / count;
    }
}