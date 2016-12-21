package project.flows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project.utils.Wait;

import static org.testng.Assert.assertTrue;
import static project.utils.WebDriverFactory.getDriver;

abstract class AbstractFlow {

    static void isElementDisplayed(final By elementToCheck) {

        final WebElement webElement = getDriver().findElement(elementToCheck);

        assertTrue(webElement.isDisplayed(), "Element " + elementToCheck + " should be displayed");
    }

    static void isElementEquals(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        Wait.getPresentElement(checkIfCapitaFantasy);

        final WebElement webElement = getDriver().findElement(checkIfCapitaFantasy);

        Assert.assertEquals(webElement.getText(), textCapitaFantasy,
                "Text " + textCapitaFantasy + " should be equals with " + webElement.getText());
    }

    static void isElementContains(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        Wait.getPresentElement(checkIfCapitaFantasy);

        final WebElement webElement = getDriver().findElement(checkIfCapitaFantasy);

        Assert.assertTrue(webElement.getText().contains(textCapitaFantasy),
                "Text " + textCapitaFantasy + " should contains " + webElement.getText());
    }

    static void clickTo(final By elementToClick) {

        Wait.getClickableElement(elementToClick);

        getDriver()
                .findElement(elementToClick)
                .click();
    }

    static void clear(final By fieldToClear) {


        getDriver()
                .findElement(fieldToClear)
                .clear();
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
