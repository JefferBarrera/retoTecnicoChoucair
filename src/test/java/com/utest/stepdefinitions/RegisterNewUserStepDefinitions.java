package com.utest.stepdefinitions;

import com.utest.questions.ElementVisibleQuestion;
import com.utest.tasks.OpenUrlTask;
import com.utest.tasks.RegisterNewUserTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterNewUserStepDefinitions {

    EnvironmentVariables environmentVariables;

    @Given("the user is on the utest home page")
    public void theUserIsOnTheUtestHomePage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                OpenUrlTask.on(environmentVariables.getProperty("pages.utest"))
        );
    }

    @When("the user registers through join today with the data")
    public void theUserRegistersThroughJoinTodayWithTheData(DataTable dataTable) {
        List<Map<String, String>> dataUser = dataTable.asMaps();
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterNewUserTask.withData(dataUser.get(0))
        );
    }

    @Then("the user should see the successful registration")
    public void theUserShouldSeeTheSuccessfulRegistration() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        "validate label with success message",
                        new ElementVisibleQuestion(),
                        equalTo(true)
                )
        );
    }

}
