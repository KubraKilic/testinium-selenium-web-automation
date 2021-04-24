import org.openqa.selenium.By;

public class Login {
    public String loginUrl = "https://www.gittigidiyor.com/uye-girisi";

    public By emailInputPath = By.id("L-UserNameField");
    public By passwordInputPath = By.id("L-PasswordField");
    public By loginButtonPath = By.id("gg-login-enter");

    public By accountPath = By.xpath("//div[@data-cy='header-user-menu']/div[@title='Hesabım']");
    public By accountUsernamePath = By.xpath("//div[@data-cy='header-user-menu']/div[@title='Hesabım']/div/span");

    public String email = "kubrakilic****@gmail.com";
    public String password = "***";  // TODO
}
