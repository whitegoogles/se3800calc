package tests;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import se3800.ConsoleApp;

import static org.junit.Assert.assertEquals;

/**
 * Created by daviesj on 1/18/2016.
 */
public class SubFeatureSteps {
    ConsoleApp consoleApp = new ConsoleApp();
    String curLine;
    @Given("^the calculator is in sub mode$")
    public void the_calculator_is_in_sub_mode() throws Throwable {
        curLine = "sub";
    }

    @When("^the user inputs \"([^\"]*)\"$")
    public void the_user_inputs(String op1) throws Throwable {
        curLine += " "+op1;
    }

    @Then("^the difference should be \"([^\"]*)\"$")
    public void the_difference_should_be(String difference) throws Throwable {
        assertEquals(difference,consoleApp.parseLine(curLine).trim());
    }

    @When("^the user inputs a really large value$")
    public void the_user_inputs_a_really_large_value() throws Throwable {
        String bigNumStr = "1";
        for(int i = 0; i<308; i+=1){
            bigNumStr+="0";
        }
        curLine += " "+bigNumStr;
    }

    @Then("^the difference should be -Infinity$")
    public void the_difference_should_be_Infinity() throws Throwable {
        assertEquals("-Infinity",consoleApp.parseLine(curLine).trim());
    }
}
