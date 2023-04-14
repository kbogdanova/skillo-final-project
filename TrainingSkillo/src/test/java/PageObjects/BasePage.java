package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait smallWait;
    protected final WebDriverWait mediumWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        smallWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mediumWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void goToUrl(String url) {
        driver.get(url);
    }

    protected void validateUrl(String url) {
        smallWait.until(ExpectedConditions.urlToBe(url));
    }

    protected void validateUrlContains(String url) {
        smallWait.until(ExpectedConditions.urlContains(url));
    }

    protected void clickElement(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected void fillText(WebElement element, String text) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        smallWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
