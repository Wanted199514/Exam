package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class OpenPageTest extends BaseTest {

    @Test
    public void searchGoogle() {
        String searchTerm = "Selenium";

        Assert.assertTrue(googlePage.googlePageIsLoaded(),"Google page is not loaded.");

        SearchPage searchPage = googlePage.find(searchTerm);

        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Search page is not loaded.");

        searchPage.assertforSearchResults();

        searchPage.checkAllSearchResults(searchTerm);

        searchPage.openSecondSearchPage();

        Assert.assertTrue(searchPage.searchPageIsLoaded(),"Second search page is not loaded.");

        searchPage.assertforSearchResults();

        searchPage.checkAllSearchResults(searchTerm);
    }
}
