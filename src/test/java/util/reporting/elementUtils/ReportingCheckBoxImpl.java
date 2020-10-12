package util.reporting.elementUtils;

import org.openqa.selenium.WebElement;
import util.common.impl.AbstractCheckBoxImpl;
import util.common.interfaces.ICheckBox;

public class ReportingCheckBoxImpl extends AbstractCheckBoxImpl implements ICheckBox {

    private WebElement fElement;

    public ReportingCheckBoxImpl(WebElement fElement) {
        this.fElement = fElement;
    }

    @Override
    protected WebElement getWebElement() {
        return fElement;
    }
}
