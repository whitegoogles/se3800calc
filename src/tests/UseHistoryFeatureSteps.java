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
public class UseHistoryFeatureSteps {
    ConsoleApp console = new ConsoleApp();
    String curLine;

    @Given("^a calculator history with the integer (\\d+)$")
    public void a_calculator_history_with_the_integer(int histInt) throws Throwable {
        console.parseLine("add 0 "+histInt);
    }

    @When("^the user enters factorial$")
    public void the_user_enters_factorial() throws Throwable {
        curLine = "fact";
    }


    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int factorial) throws Throwable {
        assertEquals(""+factorial,console.parseLine(curLine).trim());
    }

    @Given("^an empty calculator history$")
    public void an_empty_calculator_history() throws Throwable {
        console.parseLine("clear");
        curLine = "";
    }

    @Then("^the result should be Incorrect parameters provided$")
    public void the_result_should_be_Incorrect_parameters_provided() throws Throwable {
        assertEquals("Incorrect parameters provided",console.parseLine(curLine).trim());
    }

    @And("^the user enters !(\\d+)$")
    public void the_user_enters_(int historyPlace) throws Throwable {
        curLine+=" !"+historyPlace;
    }
}
