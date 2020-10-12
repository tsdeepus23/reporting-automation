package util.common.impl;

import org.junit.Assert;
import util.common.interfaces.IButton;

import java.util.logging.Logger;

public abstract class AbstractButtonImpl extends AbstractTextImpl implements IButton {

    private static final Logger LOGGER = Logger.getLogger("AbstractButtonImpl");


    @Override
    public void click() {
        Assert.assertTrue("Element is not enabled or displayed", isDisplayed() && isEnabled());
        getWebElement().click();
    }
}
