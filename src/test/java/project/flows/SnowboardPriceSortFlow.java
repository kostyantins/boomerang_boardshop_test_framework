package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static java.awt.SystemColor.window;
import static jdk.nashorn.internal.objects.NativeFunction.function;
import static project.utils.WebDriverFactory.getDriver;

@Setter
@Getter
public final class SnowboardPriceSortFlow extends AbstractFlow {

    private SnowboardPriceSortFlow() {
    }

    public static final By MIN_PRICE_INPUT_FIELD = By.id("min_price");
    public static final By MAX_PRICE_INPUT_FIELD = By.id("max_price");
    public static final By MIN_PRICE_RESULT = By.xpath("(//*[@id='woocommerce_price_filter-7']//span)[3]");
    public static final By MAX_PRICE_RESULT = By.xpath("(//*[@id='woocommerce_price_filter-7']//span)[4]");
    public static final String MIN_PRICE = "5000";
    public static final String MAX_PRICE = "10000";

    private By goToSnowboardingPage;
    private By fillMinPrice;
    private By fillMaxPrice;

    public static interface GoToSnowboardingPageStep {
        FillMinPriceStep goToSnowboardingPage(By goToSnowboardingPage);
    }

    public static interface FillMinPriceStep {
        FillMaxPriceStep fillMinPrice(By fillMinPrice);
    }

    public static interface FillMaxPriceStep {
        BuildStep fillMaxPrice(By fillMaxPrice);
    }

    public static interface BuildStep {
        SnowboardPriceSortFlow build();
    }


    public static class Builder implements GoToSnowboardingPageStep, FillMinPriceStep, FillMaxPriceStep, BuildStep {
        private By goToSnowboardingPage;
        private By fillMinPrice;
        private By fillMaxPrice;

        private Builder() {
        }

        public static GoToSnowboardingPageStep snowboardPriceSortFlow() {
            return new Builder();
        }

        @Override
        public FillMinPriceStep goToSnowboardingPage(By snowboardingLink) {

            this.goToSnowboardingPage = snowboardingLink;

            clickTo(snowboardingLink);

            return this;
        }

        @Override
        public FillMaxPriceStep fillMinPrice(By minPriceInput) {

            this.fillMinPrice = minPriceInput;

            final WebElement element = getDriver().findElement(minPriceInput);

            ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('min_price').style='display: inline';");

            element.clear();

            element.sendKeys(MIN_PRICE);

            element.submit();

            return this;
        }

        @Override
        public BuildStep fillMaxPrice(By maxPriceInput) {

            this.fillMaxPrice = maxPriceInput;

            final WebElement element = getDriver().findElement(maxPriceInput);

            ((JavascriptExecutor) getDriver()).executeScript("document.getElementById('max_price').style='display: inline';");

            element.clear();

            element.sendKeys(MAX_PRICE);

            element.submit();

            return this;
        }

        @Override
        public SnowboardPriceSortFlow build() {
            SnowboardPriceSortFlow snowboardPriceSortFlow = new SnowboardPriceSortFlow();
            snowboardPriceSortFlow.setGoToSnowboardingPage(this.goToSnowboardingPage);
            snowboardPriceSortFlow.setFillMinPrice(this.fillMinPrice);
            snowboardPriceSortFlow.setFillMaxPrice(this.fillMaxPrice);
            return snowboardPriceSortFlow;
        }
    }
}