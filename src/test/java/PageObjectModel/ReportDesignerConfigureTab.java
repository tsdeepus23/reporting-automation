package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ReportDesignerConfigureTab {

    @FindBy(css = "[id=\"rd-dotwalk-groupby\"] button")
    private WebElement reportGroupBy;

    @FindBy(css = "[id=\"rd-dotwalk-stackby\"] button")
    private WebElement reportStackBy;

    @FindBy(css = "[id =\"-sn-dot-walk-component\"] input[id=\"sn-dot-walk-search\"]")
    private WebElement configureTabQueryString;

    @FindBys({@FindBy(css = "[id=\"sn-dot-walk-list-container-\"] ul li")})
    private List<WebElement> configureTabQueryResults;

    @FindBy(css = "[id=\"checkbox-display-grid\"]")
    private WebElement displayDataLabels;

    @FindBy(id = "next-button-step-3")
    private WebElement configureTabNextButton;


    public WebElement getReportGroupBy() {
        return reportGroupBy;
    }

    public WebElement getReportStackBy() {
        return reportStackBy;
    }

    public WebElement getConfigureTabQueryString() {
        return configureTabQueryString;
    }

    public List<WebElement> getConfigureTabQueryResults() {
        return configureTabQueryResults;
    }

    public WebElement getDisplayDataLabels() {
        return displayDataLabels;
    }

    public WebElement getConfigureTabNextButton() {
        return configureTabNextButton;
    }
}
