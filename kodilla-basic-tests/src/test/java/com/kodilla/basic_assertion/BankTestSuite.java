package com.kodilla.basic_assertion;

import com.kodilla.bank.homework.Bank;
import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {

    @Test
    public void testCashMachineBalance() {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(200);

        assertEquals(250, cashMachine.getBalance());
    }

    @Test
    public void testCashMachineTransactionCount() {
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(200);

        assertEquals(3, cashMachine.getTransactionCount());
    }

    @Test
    public void testBankTotalBalance() {
        CashMachine cm1 = new CashMachine();
        cm1.addTransaction(100);
        cm1.addTransaction(-50);

        CashMachine cm2 = new CashMachine();
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        Bank bank = new Bank();
        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(150, bank.getTotalBalance());
    }

    @Test
    public void testBankTotalWithdrawals() {
        CashMachine cm1 = new CashMachine();
        cm1.addTransaction(100);
        cm1.addTransaction(-50);

        CashMachine cm2 = new CashMachine();
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        Bank bank = new Bank();
        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(2, bank.getTotalWithdrawals());
    }

    @Test
    public void testBankTotalDeposits() {
        CashMachine cm1 = new CashMachine();
        cm1.addTransaction(100);
        cm1.addTransaction(-50);

        CashMachine cm2 = new CashMachine();
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        Bank bank = new Bank();
        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(2, bank.getTotalDeposits());
    }

    @Test
    public void testBankAverageWithdrawal() {
        CashMachine cm1 = new CashMachine();
        cm1.addTransaction(-50);
        cm1.addTransaction(-100);

        Bank bank = new Bank();
        bank.addCashMachine(cm1);

        assertEquals(-75.0, bank.getAverageWithdrawal(), 1e-9);
    }

    @Test
    public void testBankAverageDeposit() {
        CashMachine cm1 = new CashMachine();
        cm1.addTransaction(100);
        cm1.addTransaction(200);

        Bank bank = new Bank();
        bank.addCashMachine(cm1);

        assertEquals(150.0, bank.getAverageDeposit(), 1e-9);
    }
}