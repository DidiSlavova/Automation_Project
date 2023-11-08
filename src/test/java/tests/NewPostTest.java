package tests;


import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.File;


public class NewPostTest extends BaseTest {

    @Test
    public void createNewPost() {
        System.out.println("1. Open homepage");
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        System.out.println("2. Login with existing user");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("DidiSlavova", "123456");

        System.out.println("3. Go to profile page and get current and all posts count");
        headerPage.goToProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        int existingPostsCount = profilePage.getExistingPostsCount();
        int allPostsCount = profilePage.getAllPostsCount();

        System.out.println("4. Go to new post");
        headerPage.goToNewPost();

        System.out.println("5. Upload a new picture");
        NewPostPage newPostPage = new NewPostPage(driver);

        File uploadFile = new File("C:\\Users\\Didi\\IdeaProjects\\Automation_Project\\src\\test\\java\\resources\\uploads\\DSC_0028-1.jpg");
        newPostPage.uploadFile(uploadFile);

        System.out.println("6. Verify that the image is visible");
        newPostPage.verifyImagePreview();

        System.out.println("7. Verify the image name is correct");
        String expectedImageName = uploadFile.getName();
        Assert.assertEquals(expectedImageName, newPostPage.getFileName(), "File name is not correct!");


        System.out.println("8. Click submit button");
        newPostPage.submitPost();

        System.out.println("9. Verify the post number has increased");
        profilePage.verifyURL();
        int existingPostsCountAfter = profilePage.getExistingPostsCount();
        int allPostsCountAfter = profilePage.getAllPostsCount();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(existingPostsCountAfter, existingPostsCount + 1, "Incorrect existing posts count");
        softAssert.assertEquals(allPostsCountAfter, allPostsCount + 1, "Incorrect all posts count");

        System.out.println("10. Verify the post details");
        PostModal postModal = new PostModal(driver);
        postModal.waitForModalToAppear();
        Assert.assertEquals(postModal.getPostUser(), "DidiSlavova", "User is incorrect!");

        softAssert.assertAll();

    }
}

