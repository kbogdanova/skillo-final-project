import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final String pathToResources = "src" + File.separator + "test" + File.separator + "upload" + File.separator;
    protected final String pathToScreenshots = "src" + File.separator + "test" + File.separator + "screenshots" + File.separator;

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][] { {"kat_stifi", "K444444"} };
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        createScreenShot(testResult);
        if(driver != null) {
            driver.quit();
        }
    }

    private void createScreenShot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(pathToScreenshots + testResult.getName() + ".jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
