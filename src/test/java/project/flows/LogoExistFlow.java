package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.utils.Wait;

import static org.testng.Assert.assertTrue;
import static project.utils.WebDriverFactory.driver;

@Getter
@Setter
public final class LogoExistFlow {

    private LogoExistFlow(){};

    public static final By LOGO = By.xpath(".//*[@id='masthead']//img[@alt='Boomerang Boardshop'][1]");

    private By waitWebElement;
    private By isWebElementDisplayed;

    public static interface WaitWebElementStep {
        CheckWebElementStep waitWebElement(By waitWebElement);
    }

    public static interface CheckWebElementStep {
        BuildStep isWebElementDisplayed(By checkWebElement);
    }

    public static interface BuildStep {
        LogoExistFlow build();
    }

    public static class Builder implements WaitWebElementStep, CheckWebElementStep, BuildStep {
        private By waitWebElement;
        private By isWebElementDisplayed;

        private Builder() {
        }

        public static WaitWebElementStep logoExistFlow() {
            return new Builder();
        }

        @Override
        public CheckWebElementStep waitWebElement(By waitWebElement) {

            this.waitWebElement = waitWebElement;

            Wait.getPresentElement(waitWebElement);

            return this;
        }

        @Override
        public BuildStep isWebElementDisplayed(By checkWebElement) {

            this.isWebElementDisplayed = checkWebElement;

            final WebElement webElement = driver.findElement(LOGO);

            assertTrue(webElement.isDisplayed(), "Home page logo should be displyed");

            return this;
        }

        @Override
        public LogoExistFlow build() {
            LogoExistFlow logoExistFlow = new LogoExistFlow();
            logoExistFlow.setWaitWebElement(this.waitWebElement);
            logoExistFlow.setIsWebElementDisplayed(this.isWebElementDisplayed);
            return logoExistFlow;
        }
    }
}
