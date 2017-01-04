package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

@Getter
@Setter
public final class LogInFlow extends AbstractFlow {

    private LogInFlow() {
    }

    @Name("Home page URL")
    @FindBy(xpath = "http://boomerang-boardshop.ua/my-account/")
    private Link homePageUrl;

    @Name("User name input field")
    @FindBy(id = "username")
    private TextInput userNameInput;

    @Name("User password input field")
    @FindBy(id = "password")
    private TextInput userPassInput;

    @Name("Authorization button")
    @FindBy(xpath = "(//*[@id='login']//input)[3]")
    private Button authorizationButton;

    public final static By USER = By.xpath("//*[@id='post-8']//strong");

    public static interface HomePageUrlStep {
        UserNameInputStep homePageUrl(Link homePageUrl);
        UserNameInputStep openLogInPage();
    }

    public static interface UserNameInputStep {
        UserPassInputStep userNameInput(TextInput userNameInput);
        UserPassInputStep setUserName();
    }

    public static interface UserPassInputStep {
        AuthorizationButtonStep userPassInput(TextInput userPassInput);
        AuthorizationButtonStep setUserPassword();
    }

    public static interface AuthorizationButtonStep {
        BuildStep authorizationButton(Button authorizationButton);
        BuildStep doAuthorization();
    }

    public static interface BuildStep {
        LogInFlow build();
    }


    public static class Builder implements HomePageUrlStep, UserNameInputStep, UserPassInputStep, AuthorizationButtonStep, BuildStep {
        private Link homePageUrl;
        private TextInput userNameInput;
        private TextInput userPassInput;
        private Button authorizationButton;

        private Builder() {
        }

        public static HomePageUrlStep logInFlow() {
            return new Builder();
        }

        @Override
        public UserNameInputStep homePageUrl(Link homePageUrl) {
            this.homePageUrl = homePageUrl;
            return this;
        }

        @Override
        public UserNameInputStep openLogInPage() {


            open("http://boomerang-boardshop.ua/my-account/");

            return this;
        }

        @Override
        public UserPassInputStep userNameInput(TextInput userNameInput) {
            this.userNameInput = userNameInput;
            return this;
        }

        @Override
        public UserPassInputStep setUserName() {

            $(By.id("username")).sendKeys("kostyantins@ukr.net");

            return this;
        }

        @Override
        public AuthorizationButtonStep userPassInput(TextInput userPassInput) {
            this.userPassInput = userPassInput;
            return this;
        }

        @Override
        public AuthorizationButtonStep setUserPassword() {

            $(By.id("password")).sendKeys("123456");

            return this;
        }

        @Override
        public BuildStep authorizationButton(Button authorizationButton) {
            this.authorizationButton = authorizationButton;
            return this;
        }

        @Override
        public BuildStep doAuthorization() {

            $(By.xpath("(//*[@id='login']//input)[3]")).click();

            return this;
        }

        @Override
        public LogInFlow build() {
            LogInFlow logInFlow = new LogInFlow();
            logInFlow.setHomePageUrl(this.homePageUrl);
            logInFlow.setUserNameInput(this.userNameInput);
            logInFlow.setUserPassInput(this.userPassInput);
            logInFlow.setAuthorizationButton(this.authorizationButton);
            return logInFlow;
        }
    }
}
