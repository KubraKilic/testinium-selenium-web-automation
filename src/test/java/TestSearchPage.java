import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestSearchPage extends Base {
    public Search search;
    public Home home;
    protected Logger logger;

    public TestSearchPage() {
        search = new Search();
        home = new Home();
        logger = LogManager.getLogger("TestSearchPage");
    }

    @Test
    public void testSearchInput() {
        driver.get(home.homeUrl);

        logger.info("Waiting search button.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search.searchButtonPath)));

        WebElement searchInputElement = driver.findElement(search.searchBoxPath);
        WebElement searchButtonElement = driver.findElement(search.searchButtonPath);

        searchInputElement.sendKeys(search.searchKeyword);
        searchButtonElement.click();

        logger.info("Waiting product container path.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(search.productsContainerPath)));

        WebElement secondPageButtonElement = driver.findElement(search.secondPagePath);
        logger.info("Scrolling to second page button.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondPageButtonElement);
        secondPageButtonElement.click();

        WebElement productsContainerElement = driver.findElement(search.productsContainerPath);
        logger.info("Waiting products container.");
        wait.until(ExpectedConditions.visibilityOf(productsContainerElement));
        String secondPageUrl = driver.getCurrentUrl();

        Assert.assertTrue(productsContainerElement.isEnabled());
        Assert.assertTrue(productsContainerElement.isDisplayed());
        Assert.assertEquals(secondPageUrl, "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
    }
}
