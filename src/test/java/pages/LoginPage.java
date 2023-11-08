package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;

public class LoginPage extends BasePage {

    public final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(css = "app-login form")
    private WebElement loginForm;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(css = ".remember-me-button")
    private WebElement rememberCheckbox;

    @FindBy(linkText = "Register")
    private WebElement registerLink;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void populateUsername(String username) {
        enterText(usernameField, username);
    }

    public void populatePassword(String password) {
        enterText(passwordField, password);
    }

    public void login(String username, String password) {
        populateUsername(username);
        populatePassword(password);
        clickSignInBtn();
    }
    public void clickSignInBtn() {
        clickElement(signInButton);
    }

    public void clickRegisterLink() {
        clickElement(registerLink);
    }

    public void verifyLoginFormVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }

}