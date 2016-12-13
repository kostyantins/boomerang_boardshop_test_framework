package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public final class CapitaFantasySearchFlow extends AbstractFlow {

    private CapitaFantasySearchFlow() {
    }

    public static final By SNOWBOARD_MENU_LINK = By.xpath("//*[@id='shopkeeper-menu-item-8181']/a");
    public static final By SNOWBOARD_DESK_LINK = By.xpath("(//*[@id='content']//a)[1]");
    public static final By SNOWBOARD_CHECKBOX_LINK = By.xpath("(//*[@id='woocommerce_product_categories-2']//a)[2]");
    public static final By SEARCH_GOODS_INPUT_FIELD = By.id("yith-s");
    public static final By CAPITA_SEARCH_RESULT_LINK = By.xpath("//*[@id='products-grid']//h3/a");
    public static final By CAPITA_FANTASY_HEADER = By.xpath("//*[@id='boomerang_product_height']//h1");


    private By clickToSnowboardLink;
    private By clickToSnowboardCheckboxLink;
    private By fillInputAs;               //fillSearchGoodsInputField
    private By submitSearchResult;
    private By checkIfCapitaFantasy;

    public static interface ClickToSnowboardLinkStep {
        ClickToSnowboardCheckboxLinkStep clickToSnowboardLink(By clickToSnowboardLink);
    }

    public static interface ClickToSnowboardCheckboxLinkStep {
        FillInputAsStep clickToSnowboardCheckboxLink(By clickToSnowboardCheckboxLink);
    }

    public static interface FillInputAsStep {
        SubmitSearchResultStep fillInput(final String textToFill, By fillInputAs);
    }

    public static interface SubmitSearchResultStep {
        CheckIfCapitaFantasyStep submitSearchResult(By submitSearchResult);
    }

    public static interface CheckIfCapitaFantasyStep {
        BuildStep checkIfCapitaFantasy(By checkIfCapitaFantasy, String textCapitaFantasy);
    }

    public static interface BuildStep {
        CapitaFantasySearchFlow build();
    }


    public static class Builder implements ClickToSnowboardLinkStep, ClickToSnowboardCheckboxLinkStep, FillInputAsStep, SubmitSearchResultStep, CheckIfCapitaFantasyStep, BuildStep {
        private By clickToSnowboardLink;
        private By clickToSnowboardCheckboxLink;
        private By fillInputAs;
        private By submitSearchResult;
        private By checkIfCapitaFantasy;

        private Builder() {
        }

        public static ClickToSnowboardLinkStep capitaFantasySearchFlow() {
            return new Builder();
        }

        @Override
        public ClickToSnowboardCheckboxLinkStep clickToSnowboardLink(By snowboardLink) {

            this.clickToSnowboardLink = snowboardLink;

            clickTo(snowboardLink);

            return this;
        }

        @Override
        public FillInputAsStep clickToSnowboardCheckboxLink(By snowboardCheckboxLink) {

            this.clickToSnowboardCheckboxLink = snowboardCheckboxLink;

            clickTo(snowboardCheckboxLink);

            return this;
        }

        @Override
        public SubmitSearchResultStep fillInput(final String textToFill, By fillInputAs) {

            this.fillInputAs = fillInputAs;

            fillInputAs(textToFill, fillInputAs);

            return this;
        }

        @Override
        public CheckIfCapitaFantasyStep submitSearchResult(By submitSearchResult) {

            this.submitSearchResult = submitSearchResult;

            driverSendEnter(submitSearchResult);

            return this;
        }

        @Override
        public BuildStep checkIfCapitaFantasy(By checkIfCapitaFantasy, String textCapitaFantasy) {

            this.checkIfCapitaFantasy = checkIfCapitaFantasy;

            isElementContains(checkIfCapitaFantasy, textCapitaFantasy);

            return this;
        }

        @Override
        public CapitaFantasySearchFlow build() {
            CapitaFantasySearchFlow capitaFantasySearchFlow = new CapitaFantasySearchFlow();
            capitaFantasySearchFlow.setClickToSnowboardLink(this.clickToSnowboardLink);
            capitaFantasySearchFlow.setClickToSnowboardCheckboxLink(this.clickToSnowboardCheckboxLink);
            capitaFantasySearchFlow.setFillInputAs(this.fillInputAs);
            capitaFantasySearchFlow.setSubmitSearchResult(this.submitSearchResult);
            capitaFantasySearchFlow.setCheckIfCapitaFantasy(this.checkIfCapitaFantasy);
            return capitaFantasySearchFlow;
        }
    }
}
