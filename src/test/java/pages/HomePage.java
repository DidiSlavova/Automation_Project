package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public final String HOME_URL = "http://training.skillo-bg.com:4200/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
       driver.get(HOME_URL);
    }
}