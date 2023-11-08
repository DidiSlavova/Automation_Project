package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class DeletePostTest extends BaseTest{


    @Test
    public void deletePost() {
        System.out.println("1. Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();


        System.out.println("2. Login with existing user");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("DidiSlavova", "123456");

        System.out.println("3. Verify that the URL is correct");
        homePage.verifyURL(homePage.HOME_URL);

        System.out.println("3. Go to profile page");
        headerPage.goToProfile();

        System.out.println("4. Username title matches the text 'DidiSlavova'");
        ProfilePage profilePage = new ProfilePage(driver);
        String actualUsernameTitle = profilePage.getUsernameTitle();
        Assert.assertEquals(actualUsernameTitle, "DidiSlavova", "Username title is incorrect!");

        System.out.println("5. Open the latest post");
        profilePage.openPost(profilePage.getExistingPostsCount() - 1);

        System.out.println("6. Verify that the post container is visible");
        PostModal postModal = new PostModal(driver);
        postModal.waitForPostContainerToAppear();

        System.out.println("7. Verify the post details");
        postModal.waitForModalToAppear();
        Assert.assertEquals(postModal.getPostUser(), "DidiSlavova", "User is incorrect!");

        System.out.println("8.Verify the delete button is clickable and click");
        postModal.deleteBtn();

        System.out.println("9.Verify the confirmation button is clickable and click");
        postModal.yesBtn();


        System.out.println("10.Verify the toast message appear");
        postModal.verifyToastMsg();


    }
}
