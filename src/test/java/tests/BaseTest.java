package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.GooglePage;

public class BaseTest {
    private WebDriver webDriver;
    GooglePage googlePage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        googlePage = new GooglePage(webDriver);
        googlePage.openGoogle();
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
