package project.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.elements.interfaces.ILocator;

public class Wait {

    private WebDriver driver;
    private ILocator locator;
    private int timeout = 30;

    public Wait(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
    }

    public final WebElement getPresentElement() {

        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    public final WebElement getClickableElement() {

        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator.getBy()));
    }
 }
