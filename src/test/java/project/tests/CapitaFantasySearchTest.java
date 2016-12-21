package project.tests;

import org.testng.annotations.Test;
import project.utils.TestRunner;

import static project.asserts.WebElementAsserts.assertThat;
import static project.flows.CapitaFantasySearchFlow.Builder.capitaFantasySearchFlow;
import static project.flows.CapitaFantasySearchFlow.*;

public class CapitaFantasySearchTest extends TestRunner {

    @Test
    public final void testCapitaFantasySearch() {

        capitaFantasySearchFlow()
                .goToSnowboardingPage(SNOWBOARDING_DESK_LINK)
                .goToSnowboardPage(SNOWBOARD_CHECKBOX_LINK)
                .fillInputAs(CAPITA_FANTASY, SEARCH_GOODS_INPUT_FIELD);

        assertThat(CAPITA_SEARCH_RESULT_LINK).textContains(CAPITA_FANTASY);
    }
}
