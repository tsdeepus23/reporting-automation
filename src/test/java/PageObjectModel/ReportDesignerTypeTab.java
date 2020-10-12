package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportDesignerTypeTab {

    @FindBy(id = "chart-type-thumb-bar")
    private WebElement barChartVisualizaion;

    @FindBy(id = "chart-type-thumb-hist")
    private WebElement histogramChartVisualizaion;

    @FindBy(id = "chart-type-thumb-pie")
    private WebElement pieChartVisualizaion;

    @FindBy(id = "chart-type-thumb-horizontal_bar")
    private WebElement horizontalBarChartVisualizaion;

    @FindBy(id = "next-button-step-2")
    private WebElement nextButtonTypeTab;

    public WebElement getHistogramChartVisualizaion() {
        return histogramChartVisualizaion;
    }

    public WebElement getPieChartVisualizaion() {
        return pieChartVisualizaion;
    }

    public WebElement getHorizontalBarChartVisualizaion() {
        return horizontalBarChartVisualizaion;
    }

    public WebElement getBarChartVisualizaion() {
        return barChartVisualizaion;
    }

    public WebElement getNextButtonTypeTab() {
        return nextButtonTypeTab;
    }

}
