package com.kodilla.basic_assertion;

import com.kodilla.bank.homework.Bank;
import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {
    private CashMachine cashMachine;
    private Bank bank;
    private CashMachine cm1;
    private CashMachine cm2;
    private Bank newBank;
    private CashMachine newCM1;

    @BeforeEach
    public void setUp() {
        cashMachine = new CashMachine();
        bank = new Bank();
        cm1 = new CashMachine();
        cm2 = new CashMachine();
        newBank = new Bank();
        newCM1 = new CashMachine();
    }

    @Test
    public void testCashMachineBalance() {
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(200);

        assertEquals(250, cashMachine.getBalance());
    }

    @Test
    public void testCashMachineTransactionCount() {
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(200);

        assertEquals(3, cashMachine.getTransactionCount());
    }

    @Test
    public void testBankTotalBalance() {
        cm1.addTransaction(100);
        cm1.addTransaction(-50);
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(150, bank.getTotalBalance());
    }

    @Test
    public void testBankTotalWithdrawals() {
        cm1.addTransaction(100);
        cm1.addTransaction(-50);
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(2, bank.getTotalWithdrawals());
    }

    @Test
    public void testBankTotalDeposits() {
        cm1.addTransaction(100);
        cm1.addTransaction(-50);
        cm2.addTransaction(200);
        cm2.addTransaction(-100);

        bank.addCashMachine(cm1);
        bank.addCashMachine(cm2);

        assertEquals(2, bank.getTotalDeposits());
    }

    @Test
    public void testBankAverageWithdrawal() {
        newCM1.addTransaction(-50);
        newCM1.addTransaction(-100);
        newBank.addCashMachine(newCM1);

        assertEquals(-75.0, newBank.getAverageWithdrawal(), 1e-9);
    }

    @Test
    public void testBankAverageDeposit() {
        newCM1.addTransaction(100);
        newCM1.addTransaction(200);
        newBank.addCashMachine(newCM1);

        assertEquals(150.0, newBank.getAverageDeposit(), 1e-9);
    }
}