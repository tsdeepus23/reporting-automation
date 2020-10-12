package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportDesignerStyleTab {

    public WebElement getReportChartSize() {
        return reportChartSize;
    }

    @FindBy(id = "select-chart-size")
    private WebElement reportChartSize;
}
