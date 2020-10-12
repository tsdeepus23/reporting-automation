package util.reporting;

import PageObjectModel.ReportDesignerConfigureTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import util.common.interfaces.ICheckBox;
import util.reporting.elementUtils.ReportingCheckBoxImpl;

import java.util.List;

public class ConfigureUtil {

    private WebDriver fDriver;

    public ConfigureUtil(WebDriver driver) {
        this.fDriver = driver;
    }

    private ReportDesignerConfigureTab getConfigureTabPage() {
        return PageFactory.initElements(fDriver, ReportDesignerConfigureTab.class);
    }

    public void setReportConfiguration(String groupBy, String stackBy, boolean showDataLable) throws Exception {
        selectConfig(groupBy, 3, getConfigureTabPage().getReportGroupBy(), "Impact");
        selectConfig(stackBy, 2, getConfigureTabPage().getReportStackBy(), "Category");
        //Thread.sleep(2 * 1000);

        ICheckBox displayDataLabel = new ReportingCheckBoxImpl(getConfigureTabPage().getDisplayDataLabels());

        if (showDataLable) {
            displayDataLabel.check();
            /*WebElement displayDataGridCheck = getConfigureTabPage().getDisplayDataLabels();
            Actions actions2 = new Actions(fDriver);
            actions2.moveToElement(displayDataGridCheck).click().perform();
            Thread.sleep(2 * 1000);*/
        }
        getConfigureTabPage().getConfigureTabNextButton().click();
        Thread.sleep(2 * 1000);

    }

    private void selectConfig(String groupBy, int i, WebElement reportGroupBy, String impact) throws InterruptedException {
        Thread.sleep(i * 1000);
        WebElement groupByElement = reportGroupBy;
        Actions actions = new Actions(fDriver);
        actions.moveToElement(groupByElement).click().perform();
        Thread.sleep(2 * 1000);
        getConfigureTabPage().getConfigureTabQueryString().sendKeys(groupBy);
        List<WebElement> groupByElements = getConfigureTabPage().getConfigureTabQueryResults();
        Thread.sleep(i * 1000);
        for (WebElement element : groupByElements) {
            String text = element.getText();
            if (text.equals(impact)) {
                element.click();
                break;
            }
        }
    }
}
