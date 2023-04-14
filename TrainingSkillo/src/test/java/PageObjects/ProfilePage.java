package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    private final String url = "http://training.skillo-bg.com:4200/users/";

    @FindBy(css = ".profile-user-settings > h2")
    WebElement pageHeading;

    @FindBy(css = ".profile-stats .profile-stat-count:first-of-type")
    WebElement postCount;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateUrl() {
        super.validateUrlContains(url);
    }

    public String getPageHeadingText() {
        return super.getText(pageHeading);
    }

    public int getPostCount() {
        return Integer.parseInt(getText(postCount));
    }
}
