import PageObjectModel.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SecondSession {
    //WebDriver declaration
    private static WebDriver firefoxDriver;

    //Declaring POM
    private LoginPage getLoginPage() {
        return PageFactory.initElements(firefoxDriver, LoginPage.class);
    }

    private ReportDesignerDataTab getDataTabPage() {
        return PageFactory.initElements(firefoxDriver, ReportDesignerDataTab.class);
    }

    private ReportDesignerTypeTab getTypeTabPage() {
        return PageFactory.initElements(firefoxDriver, ReportDesignerTypeTab.class);
    }

    private ReportDesignerConfigureTab getConfigureTabPage() {
        return PageFactory.initElements(firefoxDriver, ReportDesignerConfigureTab.class);
    }

    private ReportDesignerStyleTab getStyleTabPage() {
        return PageFactory.initElements(firefoxDriver, ReportDesignerStyleTab.class);
    }

    private HeaderAndFooter getHeaderAndFooterPage() {
        return PageFactory.initElements(firefoxDriver, HeaderAndFooter.class);
    }

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "/Users/d.thekkekkattuvelise/Deepak/master/snc/geckodriver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        firefoxDriver = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown() {
        firefoxDriver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {

        //Navigate to ServiceNow Instance
        firefoxDriver.navigate().to("http://localhost:8085/");
        //Navigate to the frame where login elements are located
        firefoxDriver.switchTo().frame("gsft_main");
        Thread.sleep(1000);

        //Performing Login
        getLoginPage().getUserName().sendKeys("admin");
        Thread.sleep(2 * 1000);
        getLoginPage().getUserPassword().sendKeys("admin");
        Thread.sleep(2 * 1000);
        getLoginPage().getLoginButton().click();
        Thread.sleep(2 * 1000);
        //Switching back to the default content and navigate to Report Designer URL
        firefoxDriver.switchTo().defaultContent();
        Thread.sleep(2 * 1000);
        firefoxDriver.navigate().to("http://localhost:8085/sys_report_template.do?sysparm_create=true");
        Thread.sleep(2 * 1000);

        //Performing actions on the Data Tab
        getDataTabPage().getReportName().sendKeys("Testing Automation");
        Thread.sleep(2 * 1000);
        Select sourceDropdown = new Select(getDataTabPage().getReportSourceType());
        sourceDropdown.selectByVisibleText("Table");
        Thread.sleep(2 * 1000);
        getDataTabPage().getReportTableSelector().click();
        Thread.sleep(2 * 1000);
        getDataTabPage().getTableQueryString().clear();
        Thread.sleep(2 * 1000);
        getDataTabPage().getTableQueryString().sendKeys("[incident]");
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

        //Performing actions required on Type tab
        WebElement barChat = getTypeTabPage().getBarChartVisualizaion();
        if (barChat.isEnabled()) {
            barChat.click();
        }
        Thread.sleep(2 * 1000);
        WebElement nextButton2 = getTypeTabPage().getNextButtonTypeTab();
        if (nextButton2.isEnabled()) {
            nextButton2.click();
        }
        Thread.sleep(2 * 1000);

        //Performing actions required on the Configure tab
        WebElement groupByElement = getConfigureTabPage().getReportGroupBy();
        Actions actions = new Actions(firefoxDriver);
        actions.moveToElement(groupByElement).click().perform();
        Thread.sleep(2 * 1000);
        getConfigureTabPage().getConfigureTabQueryString().sendKeys("Impact");
        List<WebElement> groupByElements = getConfigureTabPage().getConfigureTabQueryResults();
        Thread.sleep(3 * 1000);
        for (WebElement element : groupByElements) {
            String text = element.getText();
            if (text.equals("Impact")) {
                element.click();
                break;
            }
        }
        Thread.sleep(2 * 1000);
        WebElement stackByElement = getConfigureTabPage().getReportStackBy();
        Actions actions1 = new Actions(firefoxDriver);
        actions1.moveToElement(stackByElement).click().perform();
        Thread.sleep(2 * 1000);
        getConfigureTabPage().getConfigureTabQueryString().sendKeys("Category");
        List<WebElement> stackByElements = getConfigureTabPage().getConfigureTabQueryResults();
        Thread.sleep(2 * 1000);
        for (WebElement element : stackByElements) {
            String text = element.getText();
            if (text.equals("Category")) {
                element.click();
                break;
            }
        }
        Thread.sleep(2 * 1000);
        WebElement displayDataGridCheck = getConfigureTabPage().getDisplayDataLabels();
        Actions actions2 = new Actions(firefoxDriver);
        actions1.moveToElement(displayDataGridCheck).click().perform();
        Thread.sleep(2 * 1000);
        getConfigureTabPage().getConfigureTabNextButton().click();
        Thread.sleep(2 * 1000);

        //Performing actions on Style tab
        Select reportChartSize = new Select(getStyleTabPage().getReportChartSize());
        reportChartSize.selectByVisibleText("Medium");
        Thread.sleep(2 * 1000);

        //Saving the report
        WebElement saveButton = getHeaderAndFooterPage().getSaveReport();
        if (saveButton.isEnabled()) {
            saveButton.click();
        }
        Thread.sleep(3 * 1000);
    }
}

