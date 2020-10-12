package util.common.interfaces;

public interface IWebElement {
    /**
     * In order to see if the element is displayed
     *
     * @return
     */
    boolean isDisplayed();

    /**
     * In order to see if the element is enabled
     *
     * @return
     */
    boolean isEnabled();

    /**
     * In order to see if the element is present
     *
     * @return
     */
    boolean isPresent();

    /**
     * In order to get the attribute of the element
     *
     * @param attributeValue
     * @return
     */
    String getAttribute(String attributeValue);

}
