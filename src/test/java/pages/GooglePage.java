package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//*[@id='lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id='hplogo']")
    private WebElement bigGoogleLogo;

    /**
     * Initialize web elements on google page.
     * @param webDriver - WebDriver with Mozilla Firefox
     */
    public GooglePage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    /**
     * open Google page
     */
    public void openGoogle() {
        webDriver.get("https://www.google.com.ua/");
    }

    /**
     * input searchTerm in search field and make search
     * @param searchTerm - String with information what we want to find
     * @return SearchPage object
     */
    public SearchPage find(String searchTerm) {
        searchField.click();
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage(webDriver);
    }

    /**
     * check what google page is loaded
     * @return currentUrl, title and bigGoogleLogo
     */
    public boolean googlePageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.google.com.ua/")
                && webDriver.getTitle().equals("Google")
                && bigGoogleLogo.isDisplayed();
    }
}
