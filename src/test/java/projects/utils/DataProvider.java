package project.utils;

import project.pageobjects.HomePage;
import project.pageobjects.UserOfficePage;

import static project.enums.PageToGo.ABOUT_UA_PAGE;
import static project.enums.PageToGo.USER_OFFICE_PAGE;
import static project.enums.PageToGoConfirmElement.ABOUT_UA_TEXT_LABEL;
import static project.enums.PageToGoConfirmElement.USER_OFFICE_PAGE_LOGO;

public class DataProvider {

    private DataProvider() {
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testDataNavigation() {
        return new Object[][]{
                {USER_OFFICE_PAGE, USER_OFFICE_PAGE_LOGO},
                {ABOUT_UA_PAGE, ABOUT_UA_TEXT_LABEL}
        };

    }
}
