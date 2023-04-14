import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    @Test
    public void anonymousLikeShouldNotBeAllowed() {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();
        homePage.validateUrl();
        homePage.openFirstPost();
        homePage.modalLike();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateUrl();
        String message = loginPage.getWarningMessage();

        Assert.assertEquals(message, "You must login");
    }
}
