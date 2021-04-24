import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestLoginPage extends Base {
    public Login login;
    protected Logger logger;

    public TestLoginPage() {
        login = new Login();
        logger = LogManager.getLogger("TestLoginPage");
    }

    @Test
    public void testLogin() {
        driver.get(login.loginUrl);

        logger.info("Waiting login button.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(login.loginButtonPath)));

        WebElement emailInputElement = driver.findElement(login.emailInputPath);
        WebElement passwordInputElement = driver.findElement(login.passwordInputPath);
        WebElement loginButtonElement = driver.findElement(login.loginButtonPath);

        emailInputElement.sendKeys(login.email);
        passwordInputElement.sendKeys(login.password);
        loginButtonElement.click();

        logger.info("Waiting account information.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(login.accountPath)));

        WebElement userNameSpanElement = driver.findElement(login.accountUsernamePath);
        String userName = userNameSpanElement.getText();
        Assert.assertEquals(userName, "kubrakilic272399");
    }
}
