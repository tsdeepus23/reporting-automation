package util.reporting.elementUtils;

import org.openqa.selenium.WebElement;
import util.common.impl.AbstarctTextBoxImpl;
import util.common.interfaces.ITextBox;

public class ReportingTextBoxImpl extends AbstarctTextBoxImpl implements ITextBox  {
    private WebElement fElement;

    public ReportingTextBoxImpl(WebElement element) {
        this.fElement = element;
    }

    @Override
    protected WebElement getWebElement() {
        return fElement;
    }

    public String doWhatISay(){
        return null;
    }

    /**
     * In order to get the text label of the text elements
     *
     * @return
     */
    @Override
    public String getText() {
        return  getWebElement().getAttribute("value");
    }
}
