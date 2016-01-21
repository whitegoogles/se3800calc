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
public class MultFeatureSteps {
    ConsoleApp consoleApp = new ConsoleApp();
    String curLine;

    @Given("^the calculator is in multiply mode$")
    public void the_calculator_is_in_multiply_mode() throws Throwable {
       curLine = "mult";
    }

    @When("^the user types \"([^\"]*)\"$")
    public void the_user_types(String op) throws Throwable {
        curLine+=" "+op;

    }

    @Then("^the product should be \"([^\"]*)\"$")
    public void the_product_should_be(String product) throws Throwable {
        assertEquals(Double.parseDouble(product), Double.parseDouble(consoleApp.parseLine(curLine).trim()),1);
    }

    @When("^the user types a big number$")
    public void the_user_types_a_big_number() throws Throwable {
        String bigNumStr = "1";
        for(int i = 0; i<308; i+=1){
            bigNumStr+="0";
        }
        curLine += " "+bigNumStr;
    }

    @And("^the user types a negative number$")
    public void the_user_types_a_negative_number() throws Throwable {
        curLine += " -40";
    }

    @Then("^the product should be negative infinity$")
    public void the_product_should_be_negative_infinity() throws Throwable {
        assertEquals("-Infinity",consoleApp.parseLine(curLine).trim());
    }

    @Then("^the product should be infinity$")
    public void the_product_should_be_infinity() throws Throwable {
        assertEquals("Infinity",consoleApp.parseLine(curLine).trim());
    }
}
