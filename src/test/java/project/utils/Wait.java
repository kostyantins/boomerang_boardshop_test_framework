package project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static project.utils.WebDriverFactory.getDriver;


public final class Wait {

    private Wait() {
    }

    private static int timeout = 30;

    public static  WebElement getPresentElement(By element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static  WebElement getClickableElement(By element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static  WebElement getVisibleElement(By element) {

        return new WebDriverWait(getDriver(), timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
