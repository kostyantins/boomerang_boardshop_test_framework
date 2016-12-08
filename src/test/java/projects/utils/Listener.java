package project.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class Listener extends TestListenerAdapter {

    @Override
    public final void onTestFailure(final ITestResult result) {

        final Object currentClass = result
                .getInstance();

        final WebDriver driver = ((TestRunner) currentClass)
                .getDriver();

        final File screenShotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShotFile, new File("test-output//html//screenshots//"
                    + result.getName() + ".png"));
            Logger.logFail("<a target='_top' href='" + "screenshots/"
                    + result.getName()
                    + ".png'><b><font size='2' color='red'> Screenshot </font></b></a>");
        } catch (IOException e) {
            System.out.println("here should be some test result");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        Logger.logPass("<font size='2' color='green'> Test pass successfully </font>");
    }
}

