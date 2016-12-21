package project.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project.utils.Wait;
import ru.yandex.qatools.allure.annotations.Step;

import static project.utils.WebDriverFactory.getDriver;

public final class WebElementAsserts {

    protected By actual;

    private WebElementAsserts(final By actual) {
        this.actual = actual;
    }

    public static final WebElementAsserts assertThat(final By actual) {

        return new WebElementAsserts(actual);
    }

    @Step
    private final WebElementAsserts isNotNull() {

        if (actual == null) {
            Assert.fail("Element should be not null");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isDisplayed() {

        isNotNull();

        final WebElement webElement = Wait.getPresentElement(actual);

        if (!webElement.isDisplayed()) {

            Assert.fail("Element {" + actual.toString() + "} should be displayed !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts textContains(final String elementsText) {

        isNotNull();

        final WebElement webElement = Wait.getPresentElement(actual);

        if (!webElement
                .getText()
                .contains(elementsText)) {

            Assert.fail("Element's {" + actual.toString() + "} text {" + actual +
                    "} should contain {" + elementsText + "} !");
        }
        return this;
    }
}
