package util.common.interfaces;

import java.util.List;

public interface ISelect2 extends IWebElement {

    void select(String queryString, String valueToSelect);

    default void select(String valueToSelect) {
        select(valueToSelect, valueToSelect);
    }

    void assertSelected(String expected);

//    List<String> getAllAvailableOptions();

    void assertResultContains(String queryString, List<String> expectedChoices);

    void assertResultContains(List<String> expectedChoices);

    void assertResultsNotContains(String queryString, List<String> expectedNotToContain);

    void assertResultCountEquals(int expected);

    void assertResultEqualsTo(String queryString, List<String> expected);
}
