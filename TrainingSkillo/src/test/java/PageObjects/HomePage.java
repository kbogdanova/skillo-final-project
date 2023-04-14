package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private final String url = "http://training.skillo-bg.com:4200/posts/all";

    @FindBy(css = ".post-list-container > div:first-of-type .post-feed-img")
    WebElement postImg;

    @FindBy(css = ".post-modal-container .fa-heart")
    WebElement modalHeart;

    @FindBy(id = "toast-container")
    WebElement toastContainerElement;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToPage() {
        super.goToUrl(url);
    }

    public void validateUrl() {
        super.validateUrl(url);
    }

    public void openFirstPost() {
        clickElement(postImg);
    }

    public void modalLike() {
        clickElement(modalHeart);
    }

    public String getSuccessfulMessage() {
        return getText(toastContainerElement);
    }
}
