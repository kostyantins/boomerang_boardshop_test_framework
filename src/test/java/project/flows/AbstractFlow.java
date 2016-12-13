package project.flows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import project.utils.Wait;
import project.utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;
import static project.utils.WebDriverFactory.driver;

public abstract class AbstractFlow {

    public static WebElement waitElementPresent(final By elementToWait) {

        return Wait.getPresentElement(elementToWait);
    }

    public static WebElement waitElementClickable(final By elementToWait) {

        return Wait.getClickableElement(elementToWait);
    }

    public static void isElementDisplayed(final By elementToCheck) {

        final WebElement webElement = driver.findElement(elementToCheck);

        assertTrue(webElement.isDisplayed(), "Element " + elementToCheck + " should be displayed");
    }

    public static void isElementEquals(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        waitElementPresent(checkIfCapitaFantasy);

        final WebElement webElement = driver.findElement(checkIfCapitaFantasy);

        Assert.assertEquals(webElement.getText(), textCapitaFantasy,
                "Text " + textCapitaFantasy + " should be equals with " + webElement.getText());
    }

    public static void isElementContains(final By checkIfCapitaFantasy, final String textCapitaFantasy) {

        waitElementPresent(checkIfCapitaFantasy);

        final WebElement webElement = driver.findElement(checkIfCapitaFantasy);

        Assert.assertTrue(webElement.getText().contains(textCapitaFantasy),
                "Text " + textCapitaFantasy + " should be equals with " + webElement.getText());
    }

    public static void clickTo(final By pageToClick) {

        waitElementClickable(pageToClick);

        WebDriverFactory
                .driver
                .findElement(pageToClick)
                .click();
    }



    public static void fillInputAs(final String textToFill, final By inputTo) {

        waitElementPresent(inputTo);

        WebDriverFactory
                .driver
                .findElement(inputTo)
                .clear();

        WebDriverFactory
                .driver
                .findElement(inputTo)
                .sendKeys(textToFill);
    }

    public static void driverSendEnter(final By element) {

        WebDriverFactory
                .driver
                .findElement(element)
                .sendKeys(Keys.ENTER);
    }
}
