package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class ProfilePage extends BasePage {

    public final String PROFILE_URL = "http://training.skillo-bg.com:4200/users/";
    @FindBy(css = ".profile-user-settings > h2")
    WebElement usernameTitle;

    @FindBy(xpath = "//li[contains(text(), 'posts')]/strong")
    WebElement postsCount;

    @FindBy(css = "app-post")
    List<WebElement> existingPosts;

    @FindBy(css = ".fa-user-edit")
    WebElement editUserBtn;

    @FindBy(css = ".edit-profile-pic")
    WebElement profilePic;


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUsernameTitle() {
        wait.until(ExpectedConditions.visibilityOf(usernameTitle));
        return usernameTitle.getText();
    }

    public int getAllPostsCount() {
        wait.until(ExpectedConditions.visibilityOf(postsCount));
        return Integer.parseInt(postsCount.getText());
    }

    public int getExistingPostsCount() {
        wait.until(ExpectedConditions.visibilityOf(existingPosts.get(0)));
        return existingPosts.size();
    }

    public void openPost(int index) {
        clickElement(existingPosts.get(index));
    }

    public void verifyURL() {
        wait.until(ExpectedConditions.urlContains(PROFILE_URL));
    }


    public void editProfileBtn() {
       wait.until(ExpectedConditions.elementToBeClickable(editUserBtn));
       clickElement(editUserBtn);
    }

    public void uploadProfilePic(){
        String imagePath = "C:\\Users\\Didi\\IdeaProjects\\Automation_Project\\src\\test\\java\\resources\\uploads\\testpicture2";
        profilePic.click();
        profilePic.sendKeys(imagePath);
    }

}