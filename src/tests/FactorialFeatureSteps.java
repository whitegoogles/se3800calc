package tests;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import se3800.ConsoleApp;

import static org.junit.Assert.assertEquals;

/**
 * Created by daviesj on 1/18/2016.
 */
public class FactorialFeatureSteps {
    ConsoleApp consoleApp = new ConsoleApp();
    String curLine = "";
    @Given("^the calculator is in factorial mode$")
    public void the_calculator_is_in_factorial_mode() throws Throwable {
        curLine = "fact";
    }

    @When("^the user enters a factorial value of \"([^\"]*)\"$")
    public void the_user_enters_a_factorial_value_of(String factorialOp) throws Throwable {
        curLine +=" "+factorialOp;
    }

    @Then("^the result should be \"([^\"]*)\"$")
    public void the_result_should_be(String factorial) throws Throwable {
        assertEquals(factorial,consoleApp.parseLine(curLine).trim());
    }
}
