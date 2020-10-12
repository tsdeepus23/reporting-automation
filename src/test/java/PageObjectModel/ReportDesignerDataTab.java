package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ReportDesignerDataTab {

    @FindBy(xpath = "//*[@id=\"report-name\"]")
    private WebElement reportName;

    @FindBy(id = "select-source-type")
    private WebElement reportSourceType;

    @FindBy(id = "s2id_select-table-ajax")
    private WebElement reportTableSelector;

    @FindBy(css = "[id=\"select2-drop\"] input[class=\"select2-input\"]")
    private WebElement tableQueryString;

    @FindBys({@FindBy(css = "[id=\"select2-drop\"] ul li div")})
    private List<WebElement> queryResults;

    @FindBy(id = "next-button-step-1")
    private WebElement nextButton;

    public WebElement getReportName() {
        return reportName;
    }

    public WebElement getReportSourceType() {
        return reportSourceType;
    }

    public WebElement getReportTableSelector() {
        return reportTableSelector;
    }

    public WebElement getTableQueryString() {
        return tableQueryString;
    }

    public List<WebElement> getQueryResults() {
        return queryResults;
    }

    public WebElement getNextButton() {
        return nextButton;
    }
}
