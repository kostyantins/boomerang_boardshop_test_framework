package project.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class Listener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {

//        Object currentClass = result.getInstance();
//
//        WebDriver driver = ((project.utils.TestRunner) currentClass).getDriver();

        byte[] srcFile = ((TakesScreenshot) WebDriverFactory.driver).getScreenshotAs(OutputType.BYTES);

        saveScreenshot(srcFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {

        return screenshot;
    }
}


