package project.tests;

import org.testng.annotations.Test;
import project.flows.SnowboardPriceSortFlow;
import project.utils.TestRunner;

import static project.flows.CapitaFantasySearchFlow.SNOWBOARDING_DESK_LINK;
import static project.flows.SnowboardPriceSortFlow.*;

public class SnowboardPriceSortTest extends TestRunner {

    @Test
    public final void testSnowboardPriceSort() {

        SnowboardPriceSortFlow
                .Builder
                .snowboardPriceSortFlow()
                .clickToSnowboardLink(SNOWBOARDING_DESK_LINK)
                .fillMinPrice(MIN_PRICE, MIN_PRICE_INPUT_FIELD)
                .fillMaxPrice(MAX_PRICE, MAX_PRICE_INPUT_FIELD)
                .checkFilterResult(MIN_PRICE_RESULT, MIN_PRICE)
                .build();
    }

}
