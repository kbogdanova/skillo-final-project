import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "credentials")
    public void loginSuccessful(String username, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();

        Navigation navigation = new Navigation(driver);
        navigation.clickLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateUrl();
        loginPage.signIn(username, password);

        homePage.validateUrl();
        String message = loginPage.getSuccessfulLoginMessage();
        Assert.assertEquals(message, "Successful login!");
    }

    @Test(dataProvider = "credentials")
    public void loginUnsuccessful(String username, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();

        Navigation navigation = new Navigation(driver);
        navigation.clickLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateUrl();
        loginPage.signIn(username, "WrongPassword");
        loginPage.validateUrl();

        String message = loginPage.getUnsuccessfulLoginMessage();
        Assert.assertEquals(message, "Ivalid password");
    }
}
