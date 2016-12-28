package project.tests;

import org.testng.annotations.Test;
import project.utils.TestRunner;

import static project.asserts.WebElementAsserts.assertThat;
import static project.flows.SnowboardPriceSortFlow.Builder.snowboardPriceSortFlow;
import static project.flows.SnowboardPriceSortFlow.*;

public class SnowboardPriceSortTest extends TestRunner {

    @Test
    public final void testSnowboardPriceSort() {

        snowboardPriceSortFlow()
                .goToSnowboardingPage()
                .fillMinPrice()
                .fillMaxPrice();


        assertThat(MIN_PRICE_RESULT).isEqual(MIN_PRICE);
        assertThat(MAX_PRICE_RESULT).isEqual(MAX_PRICE);
    }
}
