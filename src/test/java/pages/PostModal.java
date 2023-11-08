package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PostModal extends BasePage {

    @FindBy(className = "post-user")
    WebElement user;

    @FindBy(className = "modal-content")
    WebElement modal;

    @FindBy(className = "profile-edit-container")
    WebElement modifyContainer;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement newPassword;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(css = "button.btn-primary")
    WebElement saveBtn;

    @FindBy(className = "post-modal-container")
    WebElement postContainer;

    @FindBy(className = "delete-ask")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary') and contains(@class, 'btn-sm') and contains(text(), 'Yes')]")
    WebElement yesBtn;

    @FindBy(className = "toast-message")
    WebElement toastMsg;

    @FindBy(linkText = "Profile picture updated")
    WebElement uploadPicToastMsg;




    public PostModal(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForModalToAppear() {
        wait.until(ExpectedConditions.visibilityOf(modal));
    }

    public String getPostUser() {
        wait.until(ExpectedConditions.visibilityOf(user));
        return user.getText();
    }

    public void waitForModifyContainerToAppear(){
        wait.until(ExpectedConditions.visibilityOf(modifyContainer));
    }

    public void populateNewPassword(String password) {
        enterText(newPassword, password);
    }

    public void populateConfirmPassword(String password) {
        enterText(confirmPassword, password);
    }

    public void saveBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        clickElement(saveBtn);
    }

    public void waitForPostContainerToAppear() {
        wait.until(ExpectedConditions.visibilityOf(postContainer));
    }

    public void deleteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        clickElement(deleteBtn);
    }

    public void yesBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(yesBtn));
        clickElement(yesBtn);
    }

    public void verifyToastMsg(){
        wait.until(ExpectedConditions.visibilityOf(toastMsg));
        String toastMsgText = toastMsg.getText();
        Assert.assertEquals(toastMsgText, "Post Deleted!",
                "Toast message incorrect. Actual message " + toastMsgText);
    }

    public void verifyUploadPicToastMsg(){
        wait.until(ExpectedConditions.visibilityOf(uploadPicToastMsg));
        String toastMsgText = uploadPicToastMsg.getText();
        Assert.assertEquals(toastMsgText, "Profile picture updated",
                "Toast message incorrect. Actual message " + toastMsgText);
    }
}

