package QdaaStore.pages.reports.procurement;

import QdaaStore.pages.inventoryMonitors.ReceiptStmtMonitoring;
import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ProcurementReports {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ProcurementReports (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public ProcurementReports navigateToReport25Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport25Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report25 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public ProcurementReports navigateToReport26Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport26Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report26 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public ProcurementReports navigateToReport27Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport27Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report27 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public ProcurementReports navigateToReport28Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport28Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report28 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public ProcurementReports navigateToReport29Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport29Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report29 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }


    private final By report25 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report26 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report27 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report28 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report29 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;


    public boolean report25IsDisplayed(){
        return waitForVisibilityElement(report25).isDisplayed();
    }
    public boolean report26IsDisplayed(){
        return waitForVisibilityElement(report26).isDisplayed();
    }
    public boolean report27IsDisplayed(){
        return waitForVisibilityElement(report27).isDisplayed();
    }
    public boolean report28IsDisplayed(){
        return waitForVisibilityElement(report28).isDisplayed();
    }
    public boolean report29IsDisplayed(){
        return waitForVisibilityElement(report29).isDisplayed();
    }




}
