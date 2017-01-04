package project.tests;

import org.testng.annotations.Test;

import static project.flows.LogInFlow.Builder.logInFlow;
import static project.flows.LogInFlow.USER;
import static project.asserts.WebElementAsserts.assertThat;

public class LogInTest {

    @Test
    public final void testLogIn() {

        logInFlow()
                .openLogInPage()
                .setUserName()
                .setUserPassword()
                .doAuthorization();

        assertThat(USER).isLogIn();
    }
}
