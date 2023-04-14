package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PostPage extends BasePage {
    private final String url = "http://training.skillo-bg.com:4200/posts/create";

    @FindBy(css = "input[name=caption]")
    WebElement captionInput;

    @FindBy(css = "input.file")
    WebElement fileInput;

    @FindBy(id = "create-post")
    WebElement createPotBtn;

    public PostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateUrl() {
        super.validateUrl(url);
    }

    public void fillCaption(String text) {
        fillText(captionInput, text);
    }

    public void uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void createPost() {
        clickElement(createPotBtn);
    }
}
