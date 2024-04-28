package QdaaStore.basess;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import QdaaStore.factoryPage.Factory;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class TestBase {
    protected WebDriver driver;
    private ExtentReports extent;
    private static ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {
        driver = new Factory().initialization();
        // Initialize ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        htmlReporter.config().setDocumentTitle("Automation Report");
        extent.attachReporter(htmlReporter);
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testResult = result.getMethod().getMethodName();
        String fileName = "target/screenshots/" + testResult + ".png";
        captureScreenShot(fileName);

        // Log test status to Extent Report
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed");
        } else {
            test.log(Status.SKIP, "Test Skipped");
        }

        driver.quit();
        extent.flush();
    }

    public void captureScreenShot(String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File(fileName));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream inputStream = new FileInputStream(fileName)) {
            test.addScreenCaptureFromPath(fileName); // Add screenshot to Extent Report
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ExtentTest getExtentTest() {
        return test;
    }

}
