package project.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class TestRunner {

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory.setDriver(browser, version, platform);

        WebDriverFactory.driver
                .get(homePageUrl);
    }

    @AfterMethod
    public final void tarnDown() {

        WebDriverFactory.driver
                .quit();
    }
}

