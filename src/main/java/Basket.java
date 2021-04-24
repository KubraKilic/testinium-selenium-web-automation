import org.openqa.selenium.By;

public class Basket {
    public String secondPageUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
    public String basketUrl = "https://www.gittigidiyor.com/sepetim";

    public By productsContainerPath = By.className("products-container");
    public By firstProductPath = By.xpath("//ul[contains(@class, 'products-container')]/li[1]/a" +
            "/div[starts-with(@id, 'item-info-block-')]/p/img");
    public By addToBasketPath = By.id("add-to-basket");
    public By basketItemCountSpanPath = By.className("basket-item-count");
    public By priceContainerPath = By.id("spp-price-grayContainer");
    public By priceDivPath = By.id("sp-price-highPrice");
    public By cartItemPath = By.xpath("//div[@class='product-group-box'][1]/div[contains(@id, 'cart-item')]");
    public By priceInBasketPath = By.xpath("//div[@class='product-group-box'][1]/div[starts-with(@id, 'cart-item')][1]" +
            "/div[contains(@class, 'product-item-box-container')]/div[5]/div[@class='total-price-box']" +
            "/div[@class='total-price']");

    public By selectAmountPath = By.xpath("//select[@class='amount'][1]");
    public By spinnerPath = By.xpath("//div[@class='product-group-box'][1]/div[starts-with(@id, 'cart-item')][1]" +
            "/div[contains(@class, 'product-item-box-container')]/div[4]/div[contains(@class, 'number-selection')]" +
            "/span[@class='spinner']");

    public By deleteIconPath = By.xpath("//div[@class='product-group-box'][1]/div[contains(@id, 'cart-item')][1]" +
            "/div[1]/div[3]/div[@class='text-box']/div[2]/div/a/i");
    public By productItemsContainerPath = By.xpath("//div[contains(@class, 'product-items-container')]");
    public By productGroupBoxPath = By.xpath("//div[contains(@class, 'product-items-container')]" +
            "/div[@class='product-group-box'][1]");
}
