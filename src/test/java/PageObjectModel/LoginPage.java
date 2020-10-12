package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "user_name")
    private WebElement userName;

    @FindBy(css = "#user_password")
    private WebElement userPassword;

    @FindBy(id= "sysverb_login")
    private  WebElement loginButton;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserPassword() {
        return userPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
