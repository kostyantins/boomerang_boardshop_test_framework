package project.flows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project.utils.Wait;

import static org.testng.Assert.assertTrue;
import static project.utils.WebDriverFactory.getDriver;

public abstract class AbstractFlow {


    public static WebElement waitElementPresent(final By elementToWait) {

        return Wait.getPresentElement(elementToWait);
    }

    public static WebElement waitElementClickable(final By elementToWait) {

        return Wait.getClickableElement(elementToWait);
    }

    public static void isElementDisplayed(final By elementToCheck) {

        final WebElement webElement = getDriver().findElement(elementToCheck);

        assertTrue(webElement.isDisplayed(), "Element " + elementToCheck + " should be displayed");
    }

    public static void isElementEquals(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        waitElementPresent(checkIfCapitaFantasy);

        final WebElement webElement = getDriver().findElement(checkIfCapitaFantasy);

        Assert.assertEquals(webElement.getText(), textCapitaFantasy,
                "Text " + textCapitaFantasy + " should be equals with " + webElement.getText());
    }

    public static void isElementContains(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        waitElementPresent(checkIfCapitaFantasy);

        final WebElement webElement = getDriver().findElement(checkIfCapitaFantasy);

        Assert.assertTrue(webElement.getText().contains(textCapitaFantasy),
                "Text " + textCapitaFantasy + " should be equals with " + webElement.getText());
    }

    public static void clickTo(final By pageToClick) {

        waitElementClickable(pageToClick);

        getDriver()
                .findElement(pageToClick)
                .click();
    }

    public static void clear(final By inputToClear) {


        getDriver()
                .findElement(inputToClear)
                .clear();
    }

    public static void fillInputAs(final String textToFill, final By inputTo) {

        waitElementPresent(inputTo);

        clear(inputTo);

        getDriver()
                .findElement(inputTo)
                .sendKeys(textToFill);
    }

    public static void driverSendEnter(final By element) {

        getDriver()
                .findElement(element)
                .sendKeys(Keys.ENTER);   // element.submit()
    }
}
