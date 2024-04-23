package QdaaStore.basess;

import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Allure;
import QdaaStore.factoryPage.Factory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;

public class TestBase {
    protected WebDriver driver;
    private ExtentTest test;
    @BeforeMethod
    public void setup() {
        driver = new Factory().initialization();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testResult = result.getMethod().getMethodName();
        String fileName = "target/screenshots/" + testResult + ".png";
        captureScreenShot(fileName);
        driver.quit();
    }

    public void captureScreenShot(String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try
                (InputStream inputStream = new FileInputStream(fileName)) {
            Allure.addAttachment("ScreenShots", inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
