package project.tests;

import org.testng.annotations.Test;
import project.utils.TestRunner;

import static project.asserts.CommonAssert.assertThat;
import static project.asserts.WebElementAsserts.isListContains;
import static project.asserts.WebElementAsserts.isListEquals;
import static project.flows.BindingsGeneralSearchFlow.Builder.bindingsGeneralSearchFlow;
import static project.flows.BindingsGeneralSearchFlow.*;

public class BindingsGeneralSearchTest extends TestRunner {

    @Test
    public void testBindingsGeneralSearch() {

        bindingsGeneralSearchFlow()
                .goToBindingPage()
                .fillBrand()
                .fillSex();

        assertThat(isListEquals(LIST_ORDER_BRAND, "SP")).isTrue();
        assertThat(isListEquals(LIST_ORDER_SEX, "UNISEX")).isTrue();
        assertThat(isListContains(LIST_ORDER_SEARCH_RESULT, "SP")).isTrue();
    }
}
