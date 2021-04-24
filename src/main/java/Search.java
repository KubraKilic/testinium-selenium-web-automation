import org.openqa.selenium.By;

public class Search {
    public By searchBoxPath = By.name("k");
    public By searchButtonPath = By.xpath("//button[@data-cy='search-find-button']");
    public By productsContainerPath = By.className("products-container");
    public By secondPagePath = By.xpath("//div[contains(@class, 'pager')][1]/ul/li[2]/a");

    public String searchKeyword = "bilgisayar";
}
