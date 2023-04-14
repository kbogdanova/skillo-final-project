import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Navigation;
import PageObjects.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @Test(dataProvider = "credentials")
    public void profileCorrect(String username, String password) {
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
        String heading = profilePage.getPageHeadingText();
        Assert.assertEquals(heading.toLowerCase(), username);
    }
}
