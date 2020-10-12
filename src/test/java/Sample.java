import PageObjectModel.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Sample {
    private static WebDriver firefoxDriver;
    //private static WebDriver chromeDriver;
    //private static WebDriver iEDriver;

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
        //chromeDriver = new ChromeDriver();
        //iEDriver = new InternetExplorerDriver();
    }

    @AfterClass
    public static void teardown() {
        firefoxDriver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        firefoxDriver.navigate().to("http://localhost:8085/");
        firefoxDriver.switchTo().frame("gsft_main");
        Thread.sleep(1000);
        //firefoxDriver.findElement(By.id("user_name")).sendKeys("admin");
        getLoginPage().getUserName().sendKeys("admin");
        Thread.sleep(3000);
        //firefoxDriver.findElement(By.cssSelector("#user_password")).sendKeys("admin");
        getLoginPage().getUserPassword().sendKeys("admin");
        Thread.sleep(3000);
        //firefoxDriver.findElement(By.cssSelector("[id='sysverb_login']")).click();
        getLoginPage().getLoginButton().click();

        Thread.sleep(3 * 1000);
        firefoxDriver.switchTo().defaultContent();

        Thread.sleep(3 * 1000);

        firefoxDriver.navigate().to("http://localhost:8085/sys_report_template.do?sysparm_create=true");
        Thread.sleep(3 * 1000);

        //firefoxDriver.findElement(By.xpath("//*[@id=\"report-name\"]")).sendKeys("Testing Automation");
        getDataTabPage().getReportName().sendKeys("Testing Automation");
        Thread.sleep(3 * 1000);

        Select sourceDropdown = new Select(getDataTabPage().getReportSourceType());
        // Select sourceDropdown = new Select(firefoxDriver.findElement(By.id("select-source-type")));
        sourceDropdown.selectByVisibleText("Table");
        Thread.sleep(2 * 1000);
        sourceDropdown.selectByIndex(0);
        Thread.sleep(2 * 1000);
        sourceDropdown.selectByIndex(1);
        Thread.sleep(2 * 1000);
        sourceDropdown.selectByValue("object:9");
        Thread.sleep(2 * 1000);

        //firefoxDriver.findElement(By.id("s2id_select-table-ajax")).click();
        getDataTabPage().getReportTableSelector().click();
        Thread.sleep(3 * 1000);
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) FirstReportingTest.firefoxDriver;
        //jsExecutor.executeScript("$j('[id=\\'s2id_select-table-ajax\\']').select2('open')");
        //Thread.sleep(2*1000);
        //firefoxDriver.findElement(By.cssSelector("[id=\"select2-drop\"] input[class=\"select2-input\"]")).clear();
        getDataTabPage().getTableQueryString().clear();
        Thread.sleep(2 * 1000);
        getDataTabPage().getTableQueryString().sendKeys("[incident]");
        //firefoxDriver.findElement(By.cssSelector("[id=\"select2-drop\"] input[class=\"select2-input\"]")).sendKeys("[incident]");
        Thread.sleep(2 * 1000);

        //Selecting Incident from the dropdown list
        //List<WebElement> selectChoiceList = firefoxDriver.findElements(By.cssSelector("[id=\"select2-drop\"] ul li div"));
        List<WebElement> selectChoiceList = getDataTabPage().getQueryResults();
        Thread.sleep(3 * 1000);
        for (WebElement element : selectChoiceList) {
            String text = element.getText();
            if (text.equals("Incident [incident]")) {
                element.click();
                break;
            }
        }
        Thread.sleep(3 * 1000);
        //WebElement nextButton = firefoxDriver.findElement(By.id("next-button-step-1"));
        WebElement nextButton = getDataTabPage().getNextButton();
        if (nextButton.isEnabled()) {
            nextButton.click();
        }

        Thread.sleep(3 * 1000);
        //WebElement barChat = firefoxDriver.findElement(By.id("chart-type-thumb-bar"));
        WebElement barChat = getTypeTabPage().getBarChartVisualizaion();
        if (barChat.isEnabled()) {
            barChat.click();
        }
        Thread.sleep(3 * 1000);
        //WebElement nextButton2 = firefoxDriver.findElement(By.id("next-button-step-2"));
        WebElement nextButton2 = getTypeTabPage().getNextButtonTypeTab();
        if (nextButton2.isEnabled()) {
            nextButton2.click();
        }
        Thread.sleep(3 * 1000);

        //Group By Elements
        //WebElement groupByElement = firefoxDriver.findElement(By.cssSelector("[id=\"rd-dotwalk-groupby\"] button"));
        WebElement groupByElement = getConfigureTabPage().getReportGroupBy();
        Actions actions = new Actions(firefoxDriver);
        actions.moveToElement(groupByElement).click().perform();
        Thread.sleep(4 * 1000);


        //firefoxDriver.findElement(By.cssSelector("[id =\"-sn-dot-walk-component\"] input[id=\"sn-dot-walk-search\"]")).sendKeys("Impact");
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

        //Stack Elements
        //WebElement stackByElement = firefoxDriver.findElement(By.cssSelector("[id=\"rd-dotwalk-stackby\"] button"));
        WebElement stackByElement = getConfigureTabPage().getReportStackBy();
        Actions actions1 = new Actions(firefoxDriver);
        actions1.moveToElement(stackByElement).click().perform();
        Thread.sleep(4 * 1000);

        getConfigureTabPage().getConfigureTabQueryString().sendKeys("Category");
        //List<WebElement> stackByElements = firefoxDriver.findElements(By.cssSelector("[id=\"sn-dot-walk-list-container-\"] ul li"));
        List<WebElement> stackByElements = getConfigureTabPage().getConfigureTabQueryResults();
        Thread.sleep(3 * 1000);
        for (WebElement element : stackByElements) {
            String text = element.getText();
            if (text.equals("Category")) {
                element.click();
                break;
            }
        }

        Thread.sleep(3 * 1000);

        //WebElement displayDataGridCheck = firefoxDriver.findElement(By.cssSelector("[id=\"checkbox-display-grid\"]"));
        WebElement displayDataGridCheck = getConfigureTabPage().getDisplayDataLabels();
        Actions actions2 = new Actions(firefoxDriver);
        actions1.moveToElement(displayDataGridCheck).click().perform();

        Thread.sleep(3 * 1000);

        getConfigureTabPage().getConfigureTabNextButton().click();
        Thread.sleep(2 * 1000);

        Select reportChartSize = new Select(getStyleTabPage().getReportChartSize());;
        reportChartSize.selectByVisibleText("Medium");

        Thread.sleep(3 * 1000);

        WebElement saveButton = getHeaderAndFooterPage().getSaveReport();
        if (saveButton.isEnabled()) {
            saveButton.click();
        }
        Thread.sleep(3 * 1000);
    }
}
