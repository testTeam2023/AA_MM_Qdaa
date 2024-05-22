package QdaaStore.pages.reports.assets;

import QdaaStore.pages.reports.procurement.ProcurementReports;
import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class assetsReports {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public assetsReports (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public assetsReports navigateToReport101Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport101Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report101 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public assetsReports navigateToReport102Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport102Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report102 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public assetsReports navigateToReport103Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport103Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report103 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public assetsReports navigateToReport104Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport104Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report104 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }


    private final By report101 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report102 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report103 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report104 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;


    public boolean report101IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
        return waitForVisibilityElement(report101).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport101Page();
            }
        }
        throw new RuntimeException("failed to open the report101 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report102IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report102).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport102Page();
            }
        }
        throw new RuntimeException("failed to open the report102 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report103IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report103).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport103Page();
            }
        }
        throw new RuntimeException("failed to open the report103 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report104IsDisplayed(){


        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report104).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport104Page();
            }
        }
        throw new RuntimeException("failed to open the report104 page check the page manually \n may bepage load Times Out or Publish Issues");
    }



}
