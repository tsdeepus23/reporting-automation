package util.common.impl;

import util.common.interfaces.ITextBox;

public abstract class AbstarctTextBoxImpl extends AbstractTextImpl implements ITextBox {


    /**
     * In order to set the set the value for the text elements
     *
     * @param value
     */
    @Override
    public void setText(String value) {
        //Assert.assertTrue("Element is not displayed", isDisplayed());
        //Assert.assertTrue("Element is not enabled", isEnabled());
        getWebElementWithWait().clear();
        getWebElementWithWait().sendKeys(value);
    }
}
