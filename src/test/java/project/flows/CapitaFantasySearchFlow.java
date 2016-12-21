package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
@Setter
public final class CapitaFantasySearchFlow extends AbstractFlow {

    private CapitaFantasySearchFlow() {
    }

    public static final By SNOWBOARDING_DESK_LINK = By.xpath("(//*[@id='content']//a)[1]");
    public static final By SNOWBOARD_CHECKBOX_LINK = By.xpath("(//*[@id='woocommerce_product_categories-2']//a)[2]");
    public static final By SEARCH_GOODS_INPUT_FIELD = By.id("yith-s");
    public static final By CAPITA_SEARCH_RESULT_LINK = By.xpath("//*[@id='products-grid']//h3/a");
    public static final By CAPITA_FANTASY_HEADER = By.xpath("//*[@id='boomerang_product_height']//h1");
    public static final String CAPITA_FANTASY = "CAPITA Space Metal Fantasy";

    private By goToSnowboardingPage;
    private By goToSnowboardPage;
    private By fillInputAs;               //fillSearchGoodsInputField

    public static interface GoToSnowboardingPageStep {
        GoToSnowboardPageStep goToSnowboardingPage(final By goToSnowboardingPage);
    }

    public static interface GoToSnowboardPageStep {
        FillInputAsStep goToSnowboardPage(final By goToSnowboardPage);
    }

    public static interface FillInputAsStep {
        BuildStep fillInputAs(final String textToFill, final By fillInputAs);
    }

    public static interface BuildStep {
        CapitaFantasySearchFlow build();
    }


    public static class Builder implements GoToSnowboardingPageStep, GoToSnowboardPageStep, FillInputAsStep, BuildStep {
        private By goToSnowboardingPage;
        private By goToSnowboardPage;
        private By fillInputAs;

        private Builder() {
        }

        public static GoToSnowboardingPageStep capitaFantasySearchFlow() {
            return new Builder();
        }

        @Step
        @Override
        public GoToSnowboardPageStep goToSnowboardingPage(final By snowboardingPage) {

            this.goToSnowboardingPage = snowboardingPage;

            clickTo(SNOWBOARDING_DESK_LINK);

            return this;
        }

        @Step
        @Override
        public FillInputAsStep goToSnowboardPage(final By snowboardPage) {

            this.goToSnowboardPage = snowboardPage;

            clickTo(SNOWBOARD_CHECKBOX_LINK);

            return this;
        }

        @Step
        @Override
        public BuildStep fillInputAs(final String textToFill, By input) {

            this.fillInputAs = input;

            CapitaFantasySearchFlow.fillInputAs(textToFill, input);

            driverSendEnter(input);

            return this;
        }

        @Override
        public CapitaFantasySearchFlow build() {
            CapitaFantasySearchFlow capitaFantasySearchFlow = new CapitaFantasySearchFlow();
            capitaFantasySearchFlow.setGoToSnowboardingPage(this.goToSnowboardingPage);
            capitaFantasySearchFlow.setGoToSnowboardPage(this.goToSnowboardPage);
            capitaFantasySearchFlow.setFillInputAs(this.fillInputAs);
            return capitaFantasySearchFlow;
        }
    }
}
