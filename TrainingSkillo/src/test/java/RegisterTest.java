import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Navigation;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest extends BaseTest {
    @Test
    public void registerSuccessful() {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();

        Navigation navigation = new Navigation(driver);
        navigation.clickLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterBtn();

        RegisterPage registerPage = new RegisterPage(driver);
        Random random = new Random();
        String username = "someuser" + random.nextInt(9999);
        String pasword = "P@ssword123";
        registerPage.register(username, username + "@mail.bg", pasword, pasword);

        homePage.validateUrl();
        String message = homePage.getSuccessfulMessage();

        Assert.assertEquals(message, "Successful register!");
    }
}
