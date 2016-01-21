package tests;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import se3800.ConsoleApp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by daviesj on 1/18/2016.
 */
public class AddFeatureSteps {
    ConsoleApp consoleApp = new ConsoleApp();
    String curLine;
    String result;

    @Then("^the sum should be Infinity$")
    public void the_sum_should_be_Infinity() throws Throwable {
        assertEquals("Infinity",consoleApp.parseLine(curLine).trim());
    }

    @Given("^the calculator is in add mode$")
    public void the_calculator_is_in_add_mode() throws Throwable {
        curLine = "add";
    }

    @When("^the user enters \"([^\"]*)\"$")
    public void the_user_enters(String op1) throws Throwable {
        curLine+= " "+op1;
    }

    @Then("^the sum should be \"([^\"]*)\"$")
    public void the_sum_should_be(String sum) throws Throwable {
        assertEquals(sum,consoleApp.parseLine(curLine).trim());
    }

    @And("^the user enters a really large number$")
    public void the_user_enters_a_really_large_number() throws Throwable {
        String bigNumStr = "1";
        for(int i = 0; i<308; i+=1){
            bigNumStr+="0";
        }
        curLine += " "+bigNumStr;
    }
}
