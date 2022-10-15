package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(xpath = "//input[@value='remember-me']")
    public WebElement rememberPasswordCheckbox;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    public LoginPage usernameField(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage passwordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage rememberPasswordCheckbox() {
        rememberPasswordCheckbox.click();
        return this;
    }
    public LoginPage loginButtonFailedTest() {
        loginButton.click();
        return this;
    }
    public AllTicketsPage loginButton() {
        loginButton.click();
        return new AllTicketsPage();
    }
}
