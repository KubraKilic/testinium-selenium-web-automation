import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


@OrderWith(Alphanumeric.class)
public class TestBasketPage extends Base {
    public Basket basket;
    protected Logger logger;

    public TestBasketPage() {
        basket = new Basket();
        logger = LogManager.getLogger("TestBasketPage");
    }

    @Test
    public void testBasket() {
        driver.get(basket.secondPageUrl);

        logger.info("Waiting products container.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(basket.productsContainerPath)));

        logger.info("Waiting first product.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(basket.firstProductPath)));

        WebElement firstProductElement = driver.findElement(basket.firstProductPath);
        Assert.assertTrue(firstProductElement.isDisplayed());
        firstProductElement.click();

        WebElement addToBasketButtonElement = driver.findElement(basket.addToBasketPath);
        WebElement priceDivElement = driver.findElement(basket.priceDivPath);
        logger.info("Waiting price container.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(basket.priceContainerPath)));
        String price = priceDivElement.getText();

        logger.info("Waiting add to basket button.");
        wait.until(ExpectedConditions.visibilityOf(addToBasketButtonElement));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToBasketButtonElement);
        addToBasketButtonElement.click();

        logger.info("Waiting basket item count.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(basket.basketItemCountSpanPath)));

        WebElement itemCountElement = driver.findElement(basket.basketItemCountSpanPath);
        String itemCount = itemCountElement.getText();
        Assert.assertEquals(itemCount, "1");

        driver.get(basket.basketUrl);
        logger.info("Waiting cart item.");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(basket.cartItemPath)));

        WebElement priceInBasketStrongElement = driver.findElement(basket.priceInBasketPath);
        Assert.assertEquals(price, priceInBasketStrongElement.getText());
    }

    @Test
    public void testIncrementProductCount() {
        WebElement firstPriceInBasketStrongElement = driver.findElement(basket.priceInBasketPath);
        String firstPrice = firstPriceInBasketStrongElement.getText();

        WebElement spinnerElement = driver.findElement(basket.spinnerPath);
        WebElement selectElement = driver.findElement(basket.selectAmountPath);
        Select countSelector = new Select(selectElement);
        countSelector.selectByValue("2");

        logger.info("Waiting spinner.");
        wait.until(ExpectedConditions.attributeContains(spinnerElement, "style", "display: none;"));

        WebElement lastPriceInBasketStrongElement = driver.findElement(basket.priceInBasketPath);
        String lastPrice = lastPriceInBasketStrongElement.getText();

        float firstPriceFloat = Float.parseFloat(firstPrice.replace(" TL", "").replace(".", "").replace(",", "."));
        float lastPriceFloat = Float.parseFloat(lastPrice.replace(" TL", "").replace(".", "").replace(",", "."));

        Assert.assertEquals(firstPriceFloat * 2, lastPriceFloat, 0.001);

    }

    @Test
    public void testProductDelete() {
        WebElement productGroupBoxElement = driver.findElement(basket.productGroupBoxPath);
        WebElement deleteIconElement = driver.findElement(basket.deleteIconPath);

        deleteIconElement.click();
        logger.info("Waiting to be deleted product group box.");
        wait.until(ExpectedConditions.invisibilityOf(productGroupBoxElement));

        WebElement productItemsContainerElement = driver.findElement(basket.productItemsContainerPath);
        Assert.assertEquals(productItemsContainerElement.getText(), "");
    }

}
