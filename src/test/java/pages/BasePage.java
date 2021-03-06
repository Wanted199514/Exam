package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;

    /**
     * Initialize web elements for different pages.
     * @param webDriver - WebDriver with Mozilla Firefox
     */
    public void initializationWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    /**
     * waiting for a request for a certain period of time
     * @param webElement - WebElement with different web elements
     */
    public void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
