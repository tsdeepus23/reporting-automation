package util.reporting.elementUtils;

import org.openqa.selenium.WebElement;
import util.common.impl.AbstractSelectImpl;
import util.common.interfaces.ISelect;

public class ReportingSelectImpl extends AbstractSelectImpl implements ISelect {

    private WebElement fElement;

    public ReportingSelectImpl(WebElement fElement) {
        this.fElement = fElement;
    }

    @Override
    protected WebElement getWebElement() {
        return fElement;
    }
}
