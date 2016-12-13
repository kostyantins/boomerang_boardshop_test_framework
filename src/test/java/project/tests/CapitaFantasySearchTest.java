package project.tests;

import org.testng.annotations.Test;
import project.flows.CapitaFantasySearchFlow;
import project.utils.TestRunner;

import static project.flows.CapitaFantasySearchFlow.*;

public class CapitaFantasySearchTest extends TestRunner {

    public static final String CAPITA_FANTASY = "CAPITA Space Metal Fantasy";

    @Test
    public final void testCapitaFantasySearch() {

        CapitaFantasySearchFlow
                .Builder
                .capitaFantasySearchFlow()
                .clickToSnowboardLink(SNOWBOARD_DESK_LINK)
                .clickToSnowboardCheckboxLink(SNOWBOARD_CHECKBOX_LINK)
                .fillInput(CAPITA_FANTASY, SEARCH_GOODS_INPUT_FIELD)
                .submitSearchResult(SEARCH_GOODS_INPUT_FIELD)
                .checkIfCapitaFantasy(CAPITA_SEARCH_RESULT_LINK, CAPITA_FANTASY)
                .build();
    }
}
