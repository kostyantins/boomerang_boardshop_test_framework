package project.asserts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project.utils.Wait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static project.utils.Sort.isListElementsContains;
import static project.utils.Sort.isListElementsEquals;
import static project.utils.WebDriverFactory.getDriver;

public final class WebElementAsserts {

    private By actual;

    WebElementAsserts(final By actual) {
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

            Assert.fail("Element {" + actual + "} should be displayed !");
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

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should contain {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public final WebElementAsserts isEqual(final String elementsText) {

        isNotNull();

        final WebElement webElement = Wait.getPresentElement(actual);

        if (!webElement
                .getText()
                .equalsIgnoreCase(elementsText)) {

            Assert.fail("Element's {" + actual + "} text {" + actual +
                    "} should be equal {" + elementsText + "} !");
        }
        return this;
    }

    @Step
    public static boolean isListContains(final By listElements, String order) {

        List<WebElement> elementList = getDriver().findElements(listElements);

        return isListElementsContains(elementList, order);
    }

    @Step
    public static boolean isListEquals(final By listElements, String order) {

        List<WebElement> elementList = getDriver().findElements(listElements);

        return isListElementsEquals(elementList, order);
    }
}
