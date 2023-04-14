package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private final String url = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordField;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    @FindBy(id = "toast-container")
    WebElement toastContainerElement;

    @FindBy(className = "toast-warning")
    WebElement toastWarningElement;

    @FindBy(css = ".login-container form p:last-of-type a")
    WebElement registerBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateUrl() {
        super.validateUrl(url);
    }

    public void signIn(String username, String password) {
        super.fillText(usernameField, username);
        super.fillText(passwordField, password);
        super.clickElement(signInBtn);
    }

    public String getSuccessfulLoginMessage() {
        return getText(toastContainerElement);
    }

    public String getUnsuccessfulLoginMessage() {
        return getText(toastContainerElement);
    }

    public String getWarningMessage() {
        return getText(toastWarningElement);
    }

    public void clickRegisterBtn() {
        clickElement(registerBtn);
    }
}
