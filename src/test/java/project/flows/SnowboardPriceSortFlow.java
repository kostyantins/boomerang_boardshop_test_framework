package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static project.utils.WebDriverFactory.getDriver;

@Setter
@Getter
public final class SnowboardPriceSortFlow extends AbstractFlow {

    private SnowboardPriceSortFlow() {
    }

    public static final By MIN_PRICE_INPUT_FIELD = By.id("min_price");  ////*[@id='woocommerce_price_filter-7']//input[@id='min_price']
    public static final By MAX_PRICE_INPUT_FIELD = By.id("max_price");
    public static final By MIN_PRICE_RESULT = By.xpath("(//*[@id='woocommerce_price_filter-7']//span)[3]");
    public static final By MAX_PRICE_RESULT = By.xpath("(//*[@id='woocommerce_price_filter-7']//span)[4]");
    public static final String MIN_PRICE = "5000";
    public static final String MAX_PRICE = "10000";

    private By clickToSnowboardLink;
    private By fillMinPrice;
    private By fillMaxPrice;
    private By checkFilterResult;

    public static interface ClickToSnowboardLinkStep {
        FillMinPriceStep clickToSnowboardLink(By clickToSnowboardLink);
    }

    public static interface FillMinPriceStep {
        FillMaxPriceStep fillMinPrice(String inputNumber, By fillMinPrice);
    }

    public static interface FillMaxPriceStep {
        CheckFilterResultStep fillMaxPrice(String inputNumber, By fillMaxPrice);
    }

    public static interface CheckFilterResultStep {
        BuildStep checkFilterResult(By checkFilterResult, String searchResult);
    }

    public static interface BuildStep {
        SnowboardPriceSortFlow build();
    }


    public static class Builder implements ClickToSnowboardLinkStep, FillMinPriceStep, FillMaxPriceStep, CheckFilterResultStep, BuildStep {
        private By clickToSnowboardLink;
        private By fillMinPrice;
        private By fillMaxPrice;
        private By checkFilterResult;

        private Builder() {
        }

        public static ClickToSnowboardLinkStep snowboardPriceSortFlow() {
            return new Builder();
        }

        @Override
        public FillMinPriceStep clickToSnowboardLink(By clickToSnowboardLink) {

            this.clickToSnowboardLink = clickToSnowboardLink;

            clickTo(clickToSnowboardLink);

            return this;
        }

        @Override
        public FillMaxPriceStep fillMinPrice(String inputNumber, By fillMinPrice) {

            this.fillMinPrice = fillMinPrice;

//            fillInputAs(inputNumber, fillMinPrice);

            final WebElement element = getDriver().findElement(fillMinPrice);
//
//            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style='visible';", element);

//            getDriver().findElement(fillMinPrice).sendKeys(inputNumber);

            final Actions actions = new Actions(getDriver());

            actions
                    .moveToElement(element)
                    .click()
                    .sendKeys(inputNumber)
                    .build()
                    .perform();


            return this;
        }

        @Override
        public CheckFilterResultStep fillMaxPrice(String inputNumber, By fillMaxPrice) {

            this.fillMaxPrice = fillMaxPrice;

//            fillInputAs(inputNumber, fillMaxPrice);

            final WebElement element = getDriver().findElement(fillMaxPrice);

//            final WebElement element = getDriver().findElement(fillMaxPrice);
//            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style='visible';", element);

//            getDriver().findElement(fillMaxPrice).sendKeys(inputNumber);

            final Actions actions = new Actions(getDriver());

            actions
                    .moveToElement(element)
                    .click()
                    .sendKeys(inputNumber)
                    .build()
                    .perform();

            return this;
        }

        @Override
        public BuildStep checkFilterResult(By checkFilterResult, String searchResult) {

            this.checkFilterResult = checkFilterResult;

            isElementEquals(checkFilterResult, searchResult);

            return this;
        }

        @Override
        public SnowboardPriceSortFlow build() {
            SnowboardPriceSortFlow snowboardPriceSortFlow = new SnowboardPriceSortFlow();
            snowboardPriceSortFlow.setClickToSnowboardLink(this.clickToSnowboardLink);
            snowboardPriceSortFlow.setFillMinPrice(this.fillMinPrice);
            snowboardPriceSortFlow.setFillMaxPrice(this.fillMaxPrice);
            snowboardPriceSortFlow.setCheckFilterResult(this.checkFilterResult);
            return snowboardPriceSortFlow;
        }
    }
}
