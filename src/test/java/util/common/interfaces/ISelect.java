package util.common.interfaces;

public interface ISelect extends IWebElement {
    /**
     * In order to set the value for Select Dropdown
     *
     * @param value
     * @param type
     */
    void setSelectByValue(String value);

    void setSelectByVisibleText(String value);

    void setSelectByIndex(int value);

    void assertSelectedEqualsTo(String expected);

}
