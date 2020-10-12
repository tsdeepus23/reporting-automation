package util.common.impl;

import PageObjectModel.ReportDesignerDataTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.common.interfaces.ISelect2;

public abstract class AbstractSelect2Impl extends AbstractWebElementImpl implements ISelect2 {

    private WebDriver fDriver;
    private ReportDesignerDataTab getDataTabPage() {
        return PageFactory.initElements(fDriver, ReportDesignerDataTab.class);
    }

    @Override
    public void select(String queryString, String valueToSelect) {
    clickSelect2();
    searchQueryString(queryString);
    selecteOption(valueToSelect);
    }



    protected void clickSelect2(){
       getWebElementWithWait().click();
    }

    protected boolean isSelect2Opened(){
        //document.querySelector('.select2-drop-active[style*=\'display: block\']') javaScript way of finding element
        //return document.querySelector('.select2-drop-active[style*=\'display: block\']')  -- to be used in javaScriptExecutor
        //.select2-drop-active[style*='display: block']
        return false;
    }

    protected void searchQueryString(String queryString){
        //.select2-drop-active[style*='display: block'] input
    }

    protected void selecteOption(String valueToSelect){
        //.select2-drop-active[style*='display: block'] ul li
    }
}
