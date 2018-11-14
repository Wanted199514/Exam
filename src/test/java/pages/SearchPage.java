package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id='logo']/img")
    private WebElement smallGoogleLogo;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id='nav']/tbody/tr/td[3]/a")
    private WebElement secondPage;

    /**
     * Initialize web elements on search page.
     * @param webDriver - WebDriver with Mozilla Firefox
     */
    public SearchPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
        waitUntilElementIsClickable(smallGoogleLogo);
    }

    /**
     * check what search page is loaded
     * @return currentUrl, title and smallGoogleLogo
     */
    public boolean searchPageIsLoaded() {

        return webDriver.getCurrentUrl().contains("https://www.google.com.ua/search?")
                && webDriver.getTitle().contains(" - Поиск в Google")
                && smallGoogleLogo.isDisplayed();
    }

    /**
     * check what all search results is loaded
     * @return quantity searchResults on page
     */
    public int searchResultsIsLoaded() {
        return searchResults.size();
    }

    /**
     * click on second page in search page
     */
    public void openSecondSearchPage() {
        secondPage.click();
    }

    /**
     * go through each search result
     * @return list of search results
     */
    private List<String> getSearchResults() {
        List<String> searchResultStringList = new ArrayList<String>();
        for (WebElement searchResult:
                searchResults) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultStringList.add(searchResultText);
        }
        return searchResultStringList;
    }

    /**
     * assert for searchResultsIsLoaded()
     */
    public void assertforSearchResults() {
        Assert.assertEquals(searchResultsIsLoaded(), 10,"searchResults count is wrong.");
    }

    /**
     * check all search results for searchTerm
     * @param searchTerm - String with information what we want to find
     */
    public void checkAllSearchResults(String searchTerm) {
        for (String searchResult:
                getSearchResults()) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm \"" + searchTerm + "\" not found in " + searchResultsIsLoaded()+".");
        }
    }
}
