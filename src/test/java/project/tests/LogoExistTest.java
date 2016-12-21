package project.tests;

import org.testng.annotations.Test;
import project.flows.LogoExistFlow;
import project.utils.TestRunner;

import static project.asserts.WebElementAsserts.assertThat;
import static project.flows.LogoExistFlow.LOGO;

public class LogoExistTest extends TestRunner {

    @Test
    public final void testLogoExist() {

        assertThat(LOGO).isDisplayed();
    }
}
