package homework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private int walletBalance;
    private int withdrawalAmount;
    private String message;

    @Given("there is ${int} in my wallet")
    public void there_is_money_in_my_wallet(int amount) {
        walletBalance = amount;
    }

    @When("I withdraw ${int}")
    public void i_withdraw_money(int amount) {
        withdrawalAmount = amount;
        if (withdrawalAmount > walletBalance) {
            message = "You don't have enough money in your wallet";
        } else {
            walletBalance -= withdrawalAmount;
        }
    }

    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        // Checking balance logic; walletBalance remains unchanged.
    }

    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        assertTrue(withdrawalAmount > walletBalance);
    }

    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_dont_have_enough_money_in_my_wallet() {
        assertEquals("You don't have enough money in your wallet", message);
    }

    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is(int expectedBalance) {
        assertEquals(expectedBalance, walletBalance);
    }
}