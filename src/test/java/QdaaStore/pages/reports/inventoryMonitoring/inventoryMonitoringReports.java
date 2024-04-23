package QdaaStore.pages.reports.inventoryMonitoring;

import QdaaStore.pages.reports.procurement.ProcurementReports;
import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class inventoryMonitoringReports {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public inventoryMonitoringReports (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public inventoryMonitoringReports navigateToReport20Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport20Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report20 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport21Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport21Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report21 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport22Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport22Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report22 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport23Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport23Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report23 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport24Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport24Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report24 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport30Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport30Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report30 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport31Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport31Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report31 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport42Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport42Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report42 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport43Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport43Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report43 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport65Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport65Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report65 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport74Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport74Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report74 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport66Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport66Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report66 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public inventoryMonitoringReports navigateToReport67Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport67Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report67 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }


    private final By report20 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report21 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report22 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report23 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report24 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report30 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report31 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report42 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report43 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report65 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report74 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report66 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report67 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;



    public boolean report20IsDisplayed(){
        return waitForVisibilityElement(report20).isDisplayed();
    }
    public boolean report21IsDisplayed(){
        return waitForVisibilityElement(report21).isDisplayed();
    }
    public boolean report22IsDisplayed(){
        return waitForVisibilityElement(report22).isDisplayed();
    }
    public boolean report23IsDisplayed(){
        return waitForVisibilityElement(report23).isDisplayed();
    }
    public boolean report24IsDisplayed(){
        return waitForVisibilityElement(report24).isDisplayed();
    }
    public boolean report30IsDisplayed(){
        return waitForVisibilityElement(report30).isDisplayed();
    }
    public boolean report31IsDisplayed(){
        return waitForVisibilityElement(report31).isDisplayed();
    }
    public boolean report42IsDisplayed(){
        return waitForVisibilityElement(report42).isDisplayed();
    }
    public boolean report43IsDisplayed(){
        return waitForVisibilityElement(report43).isDisplayed();
    }
    public boolean report65IsDisplayed(){
        return waitForVisibilityElement(report65).isDisplayed();
    }
    public boolean report66IsDisplayed(){
        return waitForVisibilityElement(report66).isDisplayed();
    }
    public boolean report67IsDisplayed(){
        return waitForVisibilityElement(report67).isDisplayed();
    }
    public boolean report74IsDisplayed(){
        return waitForVisibilityElement(report74).isDisplayed();
    }


}
