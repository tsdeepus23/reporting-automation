package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderAndFooter {

    @FindBy(id="save-report")
    private WebElement saveReport;

    public WebElement getSaveReport() {
        return saveReport;
    }
}
