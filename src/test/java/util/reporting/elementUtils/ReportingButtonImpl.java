package util.reporting.elementUtils;

import org.openqa.selenium.WebElement;
import util.common.impl.AbstractButtonImpl;
import util.common.interfaces.IButton;

public class ReportingButtonImpl extends AbstractButtonImpl implements IButton {

    private WebElement fElement;

    public ReportingButtonImpl(WebElement fElement) {
        this.fElement = fElement;
    }

    @Override
    protected WebElement getWebElement() {
        return fElement;
    }
}
