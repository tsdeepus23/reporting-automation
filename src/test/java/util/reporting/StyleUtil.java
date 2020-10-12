package util.reporting;

import PageObjectModel.ReportDesignerStyleTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.common.interfaces.ISelect;
import util.reporting.elementUtils.ReportingSelectImpl;
import util.reporting.enums.ReportSize;

public class StyleUtil {
    private WebDriver fDriver;

    public StyleUtil(WebDriver driver) {
        this.fDriver = driver;
    }

    private ReportDesignerStyleTab getStyleTabPage() {
        return PageFactory.initElements(fDriver, ReportDesignerStyleTab.class);
    }

    public void selectReportSize(ReportSize reportSize) throws Exception {
        ISelect selectReportStyle = new ReportingSelectImpl(getStyleTabPage().getReportChartSize());
        selectReportStyle.setSelectByIndex(reportSize.getIndex());
        /*Select reportChartSize = new Select(getStyleTabPage().getReportChartSize());
        switch (reportSize) {
            case SMALL:
                reportChartSize.selectByVisibleText("Small");
                break;
            case MEDIUM:
                reportChartSize.selectByVisibleText("Medium");
                break;
            case LARGE:
                reportChartSize.selectByVisibleText("Large");
                break;
            default:
                Assert.fail("The mentioned size is not available or implemented: " + reportSize);
        }
        Thread.sleep(2 * 1000);
    }*/
    }
}
