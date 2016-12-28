package project.asserts;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public final class CommonAssert {

    private boolean actual;

    CommonAssert(final Boolean actual) {
        this.actual = actual;
    }

    public static final CommonAssert assertThat(final Boolean actual) {
        return new CommonAssert(actual);
    }

    @Step
    public final CommonAssert isTrue() {

        if (!actual) {

            Assert.fail("Expected True, but in fact False!");
        }
        return this;
    }

}
