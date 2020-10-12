package util.reporting;

import PageObjectModel.HeaderAndFooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderAndFooterUtil {
    private WebDriver fDriver;

    public HeaderAndFooterUtil(WebDriver driver) {
        this.fDriver = driver;
    }

    private HeaderAndFooter getHeaderAndFooterPage() {
        return PageFactory.initElements(fDriver, HeaderAndFooter.class);
    }

    public void saveReport() throws Exception {
        WebElement saveButton = getHeaderAndFooterPage().getSaveReport();
        if (saveButton.isEnabled()) {
            saveButton.click();
        }
        Thread.sleep(3 * 1000);
    }
}
