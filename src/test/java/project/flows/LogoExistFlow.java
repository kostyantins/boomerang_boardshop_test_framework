package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public final class LogoExistFlow extends AbstractFlow {

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
        public CheckWebElementStep waitWebElement(final By webElement) {

            waitElementPresent(webElement);

            return this;
        }

        @Override
        public BuildStep isWebElementDisplayed(final By elementToCheck) {

            isElementDisplayed(elementToCheck);

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
