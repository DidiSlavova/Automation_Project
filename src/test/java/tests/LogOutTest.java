package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LogOutTest extends BaseTest {

    @Test
    public void logOutTest() {
        System.out.println("1. Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Login with existing user");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("DidiSlavova" , "123456");



        System.out.println("3. Verify that the URL is correct");
        homePage.verifyURL(homePage.HOME_URL);


        System.out.println ("4. Verify that there is a Profile button visible");
        headerPage.verifyProfileLinkVisibility();

        System.out.println("5.Click the Profile button");
        headerPage.goToProfile();

        System.out.println("6. Username title matches the text 'DidiSlavova'");
        ProfilePage profilePage = new ProfilePage(driver);
        String actualUsernameTitle = profilePage.getUsernameTitle();
        Assert.assertEquals(actualUsernameTitle, "DidiSlavova", "Username title is incorrect!");

        System.out.println("7. Verify that the Sign out button is displayed");
        Assert.assertTrue(headerPage.isSignOutBtnVisible(), "Sign out button is not visible!");

        System.out.println("8. Click the Log out button");
        headerPage.logOut();

        System.out.println("9. Verify that the login form has appeared");
        loginPage.verifyLoginFormVisible();

    }

}
