package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends BasePage {
    @FindBy(id = "nav-link-home")
    WebElement homeBtn;

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;

    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostBtn;

    public Navigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickHomeBtn() {
        super.clickElement(homeBtn);
    }

    public void clickLoginBtn() {
        super.clickElement(loginBtn);
    }

    public void clickProfileBtn() {
        super.clickElement(profileBtn);
    }

    public void clickNewPostBtn() {
        super.clickElement(newPostBtn);
    }
}
