package project.tests;

import org.testng.annotations.Test;
import project.flows.LogoExistFlow;
import project.utils.TestRunner;

import static project.flows.LogoExistFlow.LOGO;

public class LogoExistTest extends TestRunner {

    @Test
    public final void testLogoExist() {

        LogoExistFlow.Builder.logoExistFlow()
                .waitWebElement(LOGO)
                .isWebElementDisplayed(LOGO)
                .build();
    }
}
