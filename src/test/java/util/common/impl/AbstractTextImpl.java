package util.common.impl;

import util.common.interfaces.IText;

public abstract class AbstractTextImpl extends AbstractWebElementImpl implements IText {

    /**
     * In order to get the text label of the text elements
     *
     * @return
     */
    @Override
    public String getText() {
        //Assert.assertTrue("Element is not displayed", isDisplayed());
        return getWebElementWithWait().getText();
    }
}
