package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ModifyProfileTest extends BaseTest {


    @Test
    public void modifyUserProfile() {
        System.out.println("1. Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Login with existing user");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("DSlavova", "DSlavova");

        System.out.println("3. Go to profile page");
        headerPage.goToProfile();

        System.out.println("4. Username title matches the text 'DSlavova'");
        ProfilePage profilePage = new ProfilePage(driver);
        String actualUsernameTitle = profilePage.getUsernameTitle();
        Assert.assertEquals(actualUsernameTitle, "DSlavova", "Username title is incorrect!");

        System.out.println("5. Verify the EditUser button is clickable and click");
        profilePage.editProfileBtn();

        System.out.println("6. Verify that the modify container is visible");
        PostModal postModal = new PostModal(driver);
        postModal.waitForModifyContainerToAppear();

        System.out.println("7.Populate new password");
        postModal.populateNewPassword("DSlavova");

        System.out.println("8.Populate confirm password");
        postModal.populateConfirmPassword("DSlavova");

        System.out.println("9.Verify the Save button is clickable and click");
        postModal.saveBtn();

        System.out.println("10.Log out");
        headerPage.logOut();

        System.out.println("11. Verify that the login form has appeared");
        loginPage.verifyLoginFormVisible();

        System.out.println("12.Populate username and new password");
        loginPage.populateUsername("DSlavova");
        postModal.populateNewPassword("DSlavova");
        loginPage.clickSignInBtn();

        System.out.println("13. Check that Profile tab is visible");
        headerPage.isProfileLinkVisible();

    }
}