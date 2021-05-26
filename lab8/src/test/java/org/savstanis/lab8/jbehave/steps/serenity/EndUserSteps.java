package org.savstanis.lab8.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.savstanis.lab8.jbehave.pages.LystPage;

import static org.junit.Assert.assertTrue;

public class EndUserSteps {
    LystPage lystPage;

    @Step
    public void enters(String keyword) {
        lystPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        lystPage.search();
    }

    @Step
    public void should_see_header(String header) {
        assertTrue(lystPage.searchResultHeader().contains(header));
    }

    @Step
    public void is_the_home_page() {
        lystPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
