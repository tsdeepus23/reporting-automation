package util.common.impl;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import util.common.interfaces.ISelect;

public abstract class AbstractSelectImpl extends AbstractWebElementImpl implements ISelect {
    /**
     * In order to set the value for Select Dropdown
     *
     * @param value
     */
    @Override
    public void setSelectByValue(String value) {
        Select select = new Select(getWebElementWithWait());
        select.selectByValue(value);
        String selected = select.getFirstSelectedOption().getAttribute("selected");
        String selectectedValue = select.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals("true",selected);
        Assert.assertEquals(value,selectectedValue);
    }

    @Override
    public void setSelectByVisibleText(String visibleText) {
        Select select = new Select(getWebElementWithWait());
        select.selectByVisibleText(visibleText);
        assertSelectedEqualsTo(visibleText);
    }

    @Override
    public void setSelectByIndex(int index) {
        Select select = new Select(getWebElementWithWait());
        select.selectByIndex(index);
        String selected = select.getOptions().get(index).getAttribute("selected");
        Assert.assertEquals("true", selected);
    }

    @Override
    public void assertSelectedEqualsTo(String expected) {
        Select select = new Select(getWebElementWithWait());
        Assert.assertEquals(expected,select.getFirstSelectedOption().getText());

    }
}
