package project.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import project.pageobjects.*;

import java.net.MalformedURLException;

public class TestRunner {

    protected HomePage homePage;
    protected AboutUsPage aboutUsPage;
    protected AccessoriesPage accessoriesPage;
    protected DeliveryAndPaymentPage deliveryAndPaymentPage;
    protected GuarantyPage guarantyPage;
    protected ManClothesPage manClothesPage;
    protected MyProfilePage myProfilePage;
    protected RegistrationPage registrationPage;
    protected ShopsPage shopsPage;
    protected UserOfficePage userOfficePage;
    protected WomanClothesPage womanClothesPage;

    @Getter
    protected WebDriver driver;

    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        final WebDriverFactory webDriverFactory = new WebDriverFactory();

        webDriverFactory.setDriver(browser, version, platform);

        driver = webDriverFactory.getDriver();

        driver
                .get(homePageUrl);

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public final void tarnDown() {

        driver
                .quit();
    }
}

