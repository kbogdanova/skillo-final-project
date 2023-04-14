import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PostTest extends BaseTest {
    @Test(dataProvider = "credentials")
    public void createPost(String username, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();

        Navigation navigation = new Navigation(driver);
        navigation.clickLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateUrl();
        loginPage.signIn(username, password);

        homePage.validateUrl();

        navigation.clickProfileBtn();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.validateUrl();
        int initialPostCount = profilePage.getPostCount();

        navigation.clickNewPostBtn();

        PostPage postPage = new PostPage(driver);
        postPage.validateUrl();
        postPage.fillCaption("Test");
        File file = new File(pathToResources + "sofia.jpg");
        postPage.uploadFile(file);
        postPage.createPost();

        profilePage.validateUrl();
        int newPostCount = profilePage.getPostCount();

        Assert.assertEquals(newPostCount, initialPostCount + 1);
    }
}
