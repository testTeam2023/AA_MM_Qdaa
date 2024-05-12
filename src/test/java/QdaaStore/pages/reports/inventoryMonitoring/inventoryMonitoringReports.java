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


        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report20).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport20Page();
            }
        }
        throw new RuntimeException("failed to open the report20 page check the page manually ");
    }
    public boolean report21IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report21).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport21Page();
            }
        }
        throw new RuntimeException("failed to open the report21 page check the page manually ");
    }
    public boolean report22IsDisplayed()
    {
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report22).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport22Page();
            }
        }
        throw new RuntimeException("failed to open the report22 page check the page manually ");
    }
    public boolean report23IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report23).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport23Page();
            }
        }
        throw new RuntimeException("failed to open the report23 page check the page manually ");
    }
    public boolean report24IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report24).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport24Page();
            }
        }
        throw new RuntimeException("failed to open the report24 page check the page manually ");
    }
    public boolean report30IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report30).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport30Page();
            }
        }
        throw new RuntimeException("failed to open the report30 page check the page manually ");
    }
    public boolean report31IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report31).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport31Page();
            }
        }
        throw new RuntimeException("failed to open the report31 page check the page manually ");
    }
    public boolean report42IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report42).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport42Page();
            }
        }
        throw new RuntimeException("failed to open the report42 page check the page manually ");
    }
    public boolean report43IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report43).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport43Page();
            }
        }
        throw new RuntimeException("failed to open the report43 page check the page manually ");
    }
    public boolean report65IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report65).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport65Page();
            }
        }
        throw new RuntimeException("failed to open the report65 page check the page manually ");
    }
    public boolean report66IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report66).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport66Page();
            }
        }
        throw new RuntimeException("failed to open the report66 page check the page manually ");
    }
    public boolean report67IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report67).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport67Page();
            }
        }
        throw new RuntimeException("failed to open the report 67 page check the page manually ");
    }
    public boolean report74IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report74).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport74Page();
            }
        }
        throw new RuntimeException("failed to open the report 74 page check the page manually ");
    }


}
