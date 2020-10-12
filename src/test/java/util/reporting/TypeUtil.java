package util.reporting;

import PageObjectModel.ReportDesignerTypeTab;
import util.reporting.enums.ReportType;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TypeUtil {

    private WebDriver fDriver;

    public TypeUtil(WebDriver driver) {
        this.fDriver = driver;
    }

    private ReportDesignerTypeTab getTypeTabPage() {
        return PageFactory.initElements(fDriver, ReportDesignerTypeTab.class);
    }

    public void selectType(ReportType type) throws Exception {
        getTypeWebElement(type).click();
        Thread.sleep(2 * 1000);

        getTypeTabPage().getNextButtonTypeTab().click();
        Thread.sleep(3 * 1000);
    }

    private WebElement getTypeWebElement(ReportType type) {
        switch (type) {
            case BAR:
                return getTypeTabPage().getBarChartVisualizaion();
            case PIE:
                return getTypeTabPage().getPieChartVisualizaion();
            case HISTOGRAM:
                return getTypeTabPage().getHistogramChartVisualizaion();
            case HORIZONTAL_BAR:
                return getTypeTabPage().getHorizontalBarChartVisualizaion();
            default:
                Assert.fail("Provided type is not available, implement it: " + type);
        }
        return null;
    }
}
