package util.reporting;

import PageObjectModel.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.common.interfaces.IButton;
import util.common.interfaces.ITextBox;
import util.reporting.elementUtils.ReportingButtonImpl;
import util.reporting.elementUtils.ReportingTextBoxImpl;

public class LoginUtil {

    private WebDriver fDriver;

    public LoginUtil(WebDriver driver) {
        this.fDriver = driver;
    }

    private LoginPage getLoginPage() {
        return PageFactory.initElements(fDriver, LoginPage.class);
    }

    public void login(String userName, String password) throws Exception {

        //ReportingTextBoxImpl reportingTextBox = new ReportingTextBoxImpl(getLoginPage().getUserName());
        //reportingTextBox.doWhatISay();

        ITextBox textBoxUserName = new ReportingTextBoxImpl(getLoginPage().getUserName());
        IButton submitButton = new ReportingButtonImpl(getLoginPage().getLoginButton());
        ITextBox textBoxPassword = new ReportingTextBoxImpl(getLoginPage().getUserPassword());
        textBoxUserName.setText(userName);
        Assert.assertEquals(userName, textBoxUserName.getText());
        textBoxPassword.setText(password);
        Assert.assertEquals(password, textBoxUserName.getText());
        submitButton.click();


        /*
        getLoginPage().getUserName().clear();
        getLoginPage().getUserName().sendKeys(userName);
        Thread.sleep(2 * 1000);

        //Best practise to make sure that the element is found and the value is set
        Assert.assertEquals(userName, getLoginPage().getUserName().getAttribute("value"));
        getLoginPage().getUserPassword().clear();
        getLoginPage().getUserPassword().sendKeys(password);

        getLoginPage().getLoginButton().click();
        Thread.sleep(3 * 1000);
        */
    }
}
