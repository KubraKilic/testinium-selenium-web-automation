import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestHomePage extends Base {
    public Home home;
    protected Logger logger;

    public TestHomePage() {
        home = new Home();
        logger = LogManager.getLogger("TestHomePage");
    }

    @Test
    public void testHomepage() {
        driver.get("https://gittigidiyor.com");

        logger.info("Waiting title.");
        wait.until(ExpectedConditions.titleContains("GittiGidiyor"));

        String title = driver.getTitle();
        Assert.assertEquals(title, "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
    }
}
