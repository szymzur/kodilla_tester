package seasonchecker;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.*;

public class FizzBuzzStepDefinitions {

    private int number;
    private String result;

    @Given("the number is {int}")
    public void theNumberIs(int number) {
        this.number = number;
    }

    @When("I call the FizzBuzz method")
    public void iCallTheFizzBuzzMethod() {
        result = fizzBuzz(number);
    }

    @Then("the result should be {string}")
    public void theResultShouldBe(String expected) {
        assertEquals(expected, result);
    }

    public String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return "None";
        }
    }
}