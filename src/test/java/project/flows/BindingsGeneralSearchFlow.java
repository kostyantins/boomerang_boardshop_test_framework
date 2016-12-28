package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import static project.flows.CapitaFantasySearchFlow.SNOWBOARDING_DESK_LINK;

@Getter
@Setter
public final class BindingsGeneralSearchFlow extends AbstractFlow {

    private BindingsGeneralSearchFlow() {
    }

    public static final By BINDINGS_DESK_LINK = By.xpath("(//*[@id='content']//p[2]/a)[1]");
    public static final By BRAND_SP_LINK = By.xpath("(//*[@id='yith-woo-ajax-navigation-7']//a)[1]");
    public static final By SEX_UNISEX_LINK = By.xpath("(//*[@id='yith-woo-ajax-navigation-19']//a)[1]");
    //public static final By SIZE_M = By.xpath("(//*[@id='yith-woo-ajax-navigation-43']//a)[2]"); //M mn's (40,5-44)
    public static final By LIST_ORDER_BRAND = By.xpath("//*[@id='yith-woo-ajax-navigation-7']/ul//a");
    public static final By LIST_ORDER_SEX = By.xpath("//*[@id='yith-woo-ajax-navigation-19']/ul//a");
    public static final By LIST_ORDER_SEARCH_RESULT = By.xpath("//*[@id='products-grid']//h3/a");


    private By goToBindingPage;
    private By fillBrand;
    private By fillSex;

    public static interface GoToBindingPageStep {
        FillBrandStep goToBindingPage(By goToBindingPage);

        FillBrandStep goToBindingPage();
    }

    public static interface FillBrandStep {
        FillSexStep fillBrand(By fillBrand);

        FillSexStep fillBrand();
    }

    public static interface FillSexStep {
        BuildStep fillSex(By fillSex);

        BuildStep fillSex();
    }

    public static interface BuildStep {
        BindingsGeneralSearchFlow build();
    }

    public static class Builder implements GoToBindingPageStep, FillBrandStep, FillSexStep, BuildStep {
        private By goToBindingPage;
        private By fillBrand;
        private By fillSex;

        private Builder() {
        }

        public static GoToBindingPageStep bindingsGeneralSearchFlow() {
            return new Builder();
        }

        @Override
        public FillBrandStep goToBindingPage(By goToBindingPage) {
            this.goToBindingPage = goToBindingPage;
            return this;
        }

        @Override
        public FillBrandStep goToBindingPage() {

            moveToElement(SNOWBOARDING_DESK_LINK);

            clickTo(BINDINGS_DESK_LINK);

            return this;
        }

        @Override
        public FillSexStep fillBrand(By fillBrand) {
            this.fillBrand = fillBrand;
            return this;
        }

        @Override
        public FillSexStep fillBrand() {

            //final WebElement element = getDriver().findElement(BRAND_SP_LINK);

            clickTo(BRAND_SP_LINK);

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            refresh();

            return this;
        }

        @Override
        public BuildStep fillSex(By fillSex) {
            this.fillSex = fillSex;
            return this;
        }

        @Override
        public BuildStep fillSex() {

            clickTo(SEX_UNISEX_LINK);

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            refresh();

            return this;

        }

        @Override
        public BindingsGeneralSearchFlow build() {
            BindingsGeneralSearchFlow bindingsGeneralSearchFlow = new BindingsGeneralSearchFlow();
            bindingsGeneralSearchFlow.setGoToBindingPage(this.goToBindingPage);
            bindingsGeneralSearchFlow.setFillBrand(this.fillBrand);
            bindingsGeneralSearchFlow.setFillSex(this.fillSex);
            return bindingsGeneralSearchFlow;
        }
    }
}
