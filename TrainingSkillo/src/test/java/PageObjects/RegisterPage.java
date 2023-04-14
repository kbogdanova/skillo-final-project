package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    @FindBy(css = "input[name=username]")
    WebElement usernameInput;

    @FindBy(css = "input[type=email]")
    WebElement emailInput;

    @FindBy(css = "input[name=password]")
    WebElement passwordInput;

    @FindBy(css = "input[name=verify-password]")
    WebElement verifyPasswordInput;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register(String username,String email, String password, String verifyPassword) {
        fillText(usernameInput, username);
        fillText(emailInput, email);
        fillText(passwordInput, password);
        fillText(verifyPasswordInput, verifyPassword);
        clickElement(signInBtn);
    }
}
