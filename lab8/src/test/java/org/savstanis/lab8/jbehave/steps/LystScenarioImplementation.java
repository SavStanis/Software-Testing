package org.savstanis.lab8.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.savstanis.lab8.jbehave.steps.serenity.EndUserSteps;

public class LystScenarioImplementation {
    @Steps
    EndUserSteps endUserSteps;

    @Given("the user is on the lyst home page")
    public void givenTheUserIsOnTheLystHomePage() {
        endUserSteps.is_the_home_page();
    }

    @When("the user search clothes by the word '$searchQuery'")
    public void whenTheUserLooksUpTheDefinitionOf(String searchQuery) {
        endUserSteps.looks_for(searchQuery);
    }

    @Then("they should see the header '$header'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String header) {
        endUserSteps.should_see_header(header);
    }
}
