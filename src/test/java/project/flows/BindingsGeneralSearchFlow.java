package project.flows;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public final class BindingsGeneralSearchFlow extends AbstractFlow {

    private BindingsGeneralSearchFlow() {
    }

    private By clickToBindingLink;
    private By fillBrand;
    private By fillSex;
    private By fillSize;

}
