package project.flows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import project.utils.Wait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.concurrent.TimeUnit;

import static project.utils.WebDriverFactory.getDriver;

abstract class AbstractFlow extends HtmlElement {

    static void clickTo(final By elementToClick) {

        final WebElement element = Wait.getClickableElement(elementToClick);

        element
                .findElement(elementToClick)
                .click();
    }

    static void clear(final By fieldToClear) {

        getDriver()
                .findElement(fieldToClear)
                .clear();
    }

    static void submit(final By elementToSubmit) {

        getDriver()
                .findElement(elementToSubmit)
                .submit();
    }

    static void refresh() {

        getDriver()
                .navigate()
                .refresh();
    }

    static void waitTilPageLoaded() {

        getDriver()
                .manage()
                .timeouts()
                .pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    static void moveToElement(final By elementToMove) {


        final Actions actions = new Actions(getDriver());

        actions
                .moveToElement(getDriver().findElement(elementToMove))
                .perform();
    }

    static void fillInputAs(final String textToFill, final By input) {

        Wait.getPresentElement(input);

        clear(input);

        getDriver()
                .findElement(input)
                .sendKeys(textToFill);
    }

    static void driverSendEnter(final By element) {

        getDriver()
                .findElement(element)
                .sendKeys(Keys.ENTER);
    }

}
