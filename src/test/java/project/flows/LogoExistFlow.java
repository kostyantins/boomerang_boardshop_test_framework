package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import project.utils.Wait;

@Getter
@Setter
public final class LogoExistFlow extends AbstractFlow {

    private LogoExistFlow(){};

    public static final By LOGO = By.xpath("//*[@id='masthead']//img[@alt='Boomerang Boardshop'][1]");
}
