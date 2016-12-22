package project.tests;

import org.testng.annotations.Test;
import project.utils.TestRunner;

import static project.asserts.WebElementAsserts.assertThat;
import static project.flows.CapitaFantasySearchFlow.SNOWBOARDING_DESK_LINK;
import static project.flows.SnowboardPriceSortFlow.Builder.snowboardPriceSortFlow;
import static project.flows.SnowboardPriceSortFlow.*;

public class SnowboardPriceSortTest extends TestRunner {

    @Test
    public final void testSnowboardPriceSort() {

        snowboardPriceSortFlow()
                .goToSnowboardingPage(SNOWBOARDING_DESK_LINK)
                .fillMinPrice(MIN_PRICE_INPUT_FIELD)
                .fillMaxPrice(MAX_PRICE_INPUT_FIELD);

        assertThat(MIN_PRICE_RESULT).textContains(MIN_PRICE);
        assertThat(MAX_PRICE_RESULT).textContains(MAX_PRICE);
    }
}
