import util.reporting.enums.ReportSize;
import util.reporting.enums.ReportSource;
import util.reporting.enums.ReportType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.reporting.*;

public class FirstReportingTest {

    //WebDriver declaration
    private static WebDriver firefoxDriver;


    private static LoginUtil fLoginUtil;
    private static DataTabUtil fDataTabUtil;
    private static TypeUtil fTypeUtil;
    private static ConfigureUtil fConfigureUtil;
    private static StyleUtil fStyleUtil;
    private static HeaderAndFooterUtil fHeaderAndFooterUtil;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "/Users/d.thekkekkattuvelise/Deepak/master/snc/geckodriver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        firefoxDriver = new FirefoxDriver();

        //Instantiating util classes
        fLoginUtil = new LoginUtil(firefoxDriver);
        fDataTabUtil = new DataTabUtil(firefoxDriver);
        fTypeUtil = new TypeUtil(firefoxDriver);
        fConfigureUtil = new ConfigureUtil(firefoxDriver);
        fStyleUtil = new StyleUtil(firefoxDriver);
        fHeaderAndFooterUtil = new HeaderAndFooterUtil(firefoxDriver);
    }

    @AfterClass
    public static void teardown() {
        firefoxDriver.quit();
    }

    @Test
    public void firstTest() throws Exception {

        //Navigate to ServiceNow Instance
        firefoxDriver.navigate().to("http://localhost:8080/");
        //Navigate to the frame where login elements are located
        firefoxDriver.switchTo().frame("gsft_main");
        Thread.sleep(1000);

        //Performing Login
        fLoginUtil.login("admin", "admin");

        //Switching back to the default content and navigate to Report Designer URL
        firefoxDriver.switchTo().defaultContent();
        Thread.sleep(2 * 1000);
        firefoxDriver.navigate().to("http://localhost:8080/sys_report_template.do?sysparm_create=true");
        //Thread.sleep(2 * 1000);

        //Performing actions on the Data Tab
        fDataTabUtil.setReportSource("Testing Automation", ReportSource.TABLE, "[incident]");

        //Performing actions required on Type tab
        fTypeUtil.selectType(ReportType.BAR);

        //Performing actions required on the Configure tab
        fConfigureUtil.setReportConfiguration("Impact", "Category", Boolean.TRUE);

        //Performing actions on Style tab
        fStyleUtil.selectReportSize(ReportSize.MEDIUM);

        //Saving the report
        fHeaderAndFooterUtil.saveReport();
    }
}
