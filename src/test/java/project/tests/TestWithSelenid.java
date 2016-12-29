package project.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithSelenid {

    @Test
    public final void selenidTest() throws InterruptedException {

        open("http://boomerang-boardshop.ua/snowboarding/fastening-snowboard/");
        $(By.xpath("(//*[@id='yith-woo-ajax-navigation-7']//a)[1]")).click();
        Thread.sleep(15000);
        $(By.xpath("(//*[@id='yith-woo-ajax-navigation-19']//a)[1]")).click();
        Thread.sleep(15000);
        $(By.xpath("//*[@id='yith-woo-ajax-navigation-7']/ul//a")).shouldHave(text("SP"));
        $(By.xpath("//*[@id='yith-woo-ajax-navigation-19']/ul//a")).shouldHave(text("UNISEX"));

    }

}

