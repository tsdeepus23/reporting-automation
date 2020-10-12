package util.reporting;

import PageObjectModel.ReportDesignerDataTab;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.common.interfaces.ISelect;
import util.common.interfaces.ITextBox;
import util.reporting.elementUtils.ReportingSelectImpl;
import util.reporting.elementUtils.ReportingTextBoxImpl;
import util.reporting.enums.ReportSource;

import java.util.List;

public class DataTabUtilOld {

    private WebDriver fDriver;

    public DataTabUtilOld(WebDriver driver) {
        this.fDriver = driver;
    }

    private ReportDesignerDataTab getDataTabPage() {
        return PageFactory.initElements(fDriver, ReportDesignerDataTab.class);
    }

    public void setReportSource(String reportName, ReportSource reportSource, String source) throws Exception {
        ITextBox textReportTitle = new ReportingTextBoxImpl(getDataTabPage().getReportName());
        textReportTitle.setText(reportName);
        Assert.assertEquals(reportName, textReportTitle.getText());
        //getDataTabPage().getReportName().sendKeys(reportName);
        //Thread.sleep(1 * 1000);
        //selectReportSource(reportSource);

        ISelect selectReportSource = new ReportingSelectImpl(getDataTabPage().getReportSourceType());
        selectReportSource.setSelectByVisibleText(reportSource.getVisibleText());

        Thread.sleep(2 * 1000);
        getDataTabPage().getReportTableSelector().click();
        Thread.sleep(2 * 1000);
        getDataTabPage().getTableQueryString().clear();
        Thread.sleep(2 * 1000);
        getDataTabPage().getTableQueryString().sendKeys(source);
        Thread.sleep(2 * 1000);
        List<WebElement> selectChoiceList = getDataTabPage().getQueryResults();
        Thread.sleep(2 * 1000);
        for (WebElement element : selectChoiceList) {
            String text = element.getText();
            if (text.equals("Incident [incident]")) {
                element.click();
                break;
            }
        }
        Thread.sleep(2 * 1000);
        WebElement nextButton = getDataTabPage().getNextButton();
        if (nextButton.isEnabled()) {
            nextButton.click();
        }
        Thread.sleep(2 * 1000);
    }

    public void selectReportSource(ReportSource source) throws Exception {
        /*ISelect selectReportSource = new ReportingSelectImpl(getDataTabPage().getReportSourceType());
        selectReportSource.setSelectByVisibleText(source.getVisibleText());
//        Select sourceDropdown = new Select(getDataTabPage().getReportSourceType());
//        switch (source) {
//            case TABLE:
//                sourceDropdown.selectByVisibleText(source.getVisibleText());
//                break;
//            case DATA_SOURCE:
//                sourceDropdown.selectByVisibleText(source.getVisibleText());
//                break;
//            default:
//                Assert.fail("Selected source type implementation is not available");
//        }*/
    }

}
