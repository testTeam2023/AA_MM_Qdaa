package QdaaStore.pages.reports.mainOperations;

import QdaaStore.pages.reports.assets.assetsReports;
import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class MainOperationsReports {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public MainOperationsReports (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public MainOperationsReports navigateToReport1Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport1Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report1 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport2Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport2Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report2 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport3Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport3Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report3 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport4Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport4Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report4 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport5Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport5Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report5 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport6Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport6Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report6 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport7Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport7Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report7 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport8Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport8Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report8 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport9Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport9Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report9 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport10Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport10Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report10 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport11Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport11Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report11 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport12Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport12Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report12 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport13Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport13Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report13 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport14Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport14Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report14 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport15Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport15Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report15 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport16Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport16Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report16 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport17Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport17Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report17 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport18Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport18Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report18 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport19Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport19Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report19 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    public MainOperationsReports navigateToReport51Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport51Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report51 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport39Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport39Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report39 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport47Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport47Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report47 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport49Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport49Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report49 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }
    public MainOperationsReports navigateToReport50Page() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReport50Page());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Report50 page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }





    private final By report1 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report2 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report3 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report4 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report5 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report6 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report7 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report8 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report9 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report10 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report11 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report12 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report13 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report14 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report15 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report16 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report17 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report18 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report19 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report51 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report39 = By.xpath("//*[@id=\"lbl_ReportTitle\"]") ;
    private final By report47 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report49 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;
    private final By report50 = By.xpath("//*[@id=\"lbl_ReportTitle\"]/i") ;


    public boolean report1IsDisplayed(){return waitForVisibilityElement(report1).isDisplayed();}
    public boolean report2IsDisplayed(){
        return waitForVisibilityElement(report2).isDisplayed();
    }
    public boolean report3IsDisplayed(){
        return waitForVisibilityElement(report3).isDisplayed();
    }
    public boolean report4IsDisplayed(){
        return waitForVisibilityElement(report4).isDisplayed();
    }
    public boolean report5IsDisplayed(){return waitForVisibilityElement(report5).isDisplayed();}
    public boolean report6IsDisplayed(){
        return waitForVisibilityElement(report6).isDisplayed();
    }
    public boolean report7IsDisplayed(){
        return waitForVisibilityElement(report7).isDisplayed();
    }
    public boolean report8IsDisplayed(){
        return waitForVisibilityElement(report8).isDisplayed();
    } public boolean report9IsDisplayed(){return waitForVisibilityElement(report9).isDisplayed();}
    public boolean report10IsDisplayed(){
        return waitForVisibilityElement(report10).isDisplayed();
    }
    public boolean report11IsDisplayed(){
        return waitForVisibilityElement(report11).isDisplayed();
    }
    public boolean report12IsDisplayed(){
        return waitForVisibilityElement(report12).isDisplayed();
    } public boolean report13IsDisplayed(){return waitForVisibilityElement(report13).isDisplayed();}
    public boolean report14IsDisplayed(){
        return waitForVisibilityElement(report14).isDisplayed();
    }
    public boolean report15IsDisplayed(){
        return waitForVisibilityElement(report15).isDisplayed();
    }
    public boolean report16IsDisplayed(){
        return waitForVisibilityElement(report16).isDisplayed();
    } public boolean report17IsDisplayed(){return waitForVisibilityElement(report17).isDisplayed();}
    public boolean report18IsDisplayed(){
        return waitForVisibilityElement(report18).isDisplayed();
    }
    public boolean report19IsDisplayed(){
        return waitForVisibilityElement(report19).isDisplayed();
    }
    public boolean report51IsDisplayed(){
        return waitForVisibilityElement(report51).isDisplayed();
    }
    public boolean report39IsDisplayed(){return waitForVisibilityElement(report39).isDisplayed();}
    public boolean report47IsDisplayed(){
        return waitForVisibilityElement(report47).isDisplayed();
    }
    public boolean report49IsDisplayed(){
        return waitForVisibilityElement(report49).isDisplayed();
    }
    public boolean report50IsDisplayed(){
        return waitForVisibilityElement(report50).isDisplayed();
    }





}
