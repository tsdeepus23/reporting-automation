package util.common.impl;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import util.common.interfaces.ICheckBox;

public abstract class AbstractCheckBoxImpl extends  AbstractWebElementImpl implements ICheckBox {

    @Override
    public void check() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getWebElementWithWait());
        //getWebElementWithWait().click();
        String status = getWebElementWithWait().getAttribute("class");
        Assert.assertEquals("checkbox ng-valid ng-dirty ng-valid-parse ng-touched ng-not-empty",status);
    }

    @Override
    public void unCheck() {
        getWebElementWithWait().click();
        String status = getWebElementWithWait().getAttribute("class");
        Assert.assertEquals("checkbox ng-valid ng-dirty ng-valid-parse ng-touched ng-empty",status);
    }
}
