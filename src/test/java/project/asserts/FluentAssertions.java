package project.asserts;

import org.openqa.selenium.By;

public final class FluentAssertions {

    private FluentAssertions() {
    }

    public static final WebElementAsserts assertThat(final By actual) {
        return new WebElementAsserts(actual);
    }

    public static final CommonAssert assertThat(final Boolean actual) {
        return new CommonAssert(actual);
    }
}
