package project.utils;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static project.utils.WebDriverFactory.getDriver;
import static project.utils.WebDriverFactory.setDriver;

@Listeners({Listener.class})
public class TestRunner {

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        setDriver(browser, version, platform);

        getDriver()
                .get(homePageUrl);
    }

    @AfterMethod
    public final void tarnDown() {

        if (getDriver() != null) {
            try {
                getDriver()
                        .quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****" + e);
            }
        }
    }
}

