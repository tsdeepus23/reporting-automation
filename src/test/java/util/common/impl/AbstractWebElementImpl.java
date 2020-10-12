package util.common.impl;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import util.common.interfaces.IWebElement;

import java.time.Duration;
import java.util.function.Function;
import java.util.logging.Logger;

public abstract class AbstractWebElementImpl implements IWebElement {
    private static final Logger LOGGER = Logger.getLogger("AbstractWebElementImpl");

    /**
     * In order to see if the element is displayed
     *
     * @return
     */
    @Override
    public boolean isDisplayed() {
        new FluentWait<>(getWebElement())
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(60))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotVisibleException.class)
                .until(new Function<WebElement, Boolean>() {
                    @Override
                    public Boolean apply(WebElement webElement) {
                        boolean displayed = getWebElement().isDisplayed();
                        LOGGER.info("Waiting for the element to be displayed, current state is : " + displayed);
                        return displayed;
                    }
                });
        return getWebElement().isDisplayed();
    }

    /**
     * In order to see if the element is enabled
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        new FluentWait<>(getWebElement())
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(60))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotVisibleException.class)
                .until(webElement -> {
                    boolean enabled = getWebElement().isEnabled();
                    LOGGER.info("Waiting for the element to be enabled, current state is : " + enabled);
                    return enabled;
                });
        return getWebElement().isEnabled();
    }

    /**
     * In order to see if the element is present
     *
     * @return
     */
    @Override
    public boolean isPresent() {
        return false;
    }

    /**
     * In order to get the attribute of the element
     *
     * @param attributeValue
     * @return
     */
    @Override
    public String getAttribute(String attributeValue) {
        Assert.assertTrue("Element is not displayed", isDisplayed());
        return getWebElement().getAttribute(attributeValue);
    }

    protected abstract WebElement getWebElement();

    protected WebElement getWebElementWithWait(){
        Assert.assertTrue("Element is not either displayed or enabled", isDisplayed() && isEnabled());
        return getWebElement();
    }
}
