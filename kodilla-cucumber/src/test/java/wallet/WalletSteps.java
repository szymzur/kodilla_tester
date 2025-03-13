package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import wallet.CashSlot;
import wallet.Cashier;
import wallet.Wallet;

public class WalletSteps {
    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();

    @Given("I have deposited $200 in my wallet")
    public void i_have_deposited_$200_in_my_wallet() {
        wallet.deposit(200);
        Assertions.assertEquals(200, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request $30")
    public void i_request_$30() {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 30);
    }

    @Then("$30 should be dispensed")
    public void $30_should_be_dispensed() {
        Assertions.assertEquals(30, cashSlot.getContents());
    }

    @When("I request $300")
    public void i_request_$300() {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 300);
    }

    @Then("the withdrawal should be denied and no cash should be dispensed")
    public void the_withdrawal_should_be_denied() {
        Assertions.assertEquals(0, cashSlot.getContents());
        Assertions.assertEquals(200, wallet.getBalance(), "Balance should remain unchanged");
    }

    @When("I request $200")
    public void i_request_$200() {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 200);
    }

    @Then("$200 should be dispensed and the wallet balance should be zero")
    public void $200_should_be_dispensed() {
        Assertions.assertEquals(200, cashSlot.getContents());
        Assertions.assertEquals(0, wallet.getBalance(), "Wallet balance should be zero");
    }

    @Given("I have withdrawn $50")
    public void i_have_withdrawn_$50() {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 50);
        Assertions.assertEquals(50, cashSlot.getContents());
        Assertions.assertEquals(150, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I deposit $100")
    public void i_deposit_$100() {
        wallet.deposit(100);
    }

    @Then("the wallet balance should be $250")
    public void the_wallet_balance_should_be_$250() {
        Assertions.assertEquals(250, wallet.getBalance(), "Incorrect wallet balance");
    }
}
