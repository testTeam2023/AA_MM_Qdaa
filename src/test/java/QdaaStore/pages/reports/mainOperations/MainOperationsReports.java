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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
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


    public boolean report1IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report1).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport1Page();

            }
        }
        throw new RuntimeException("failed to open the report1 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report2IsDisplayed(){


        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report2).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport2Page();

            }
        }
        throw new RuntimeException("failed to open the report2 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report3IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report3).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport3Page();

            }
        }
        throw new RuntimeException("failed to open the report3 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report4IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report4).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport4Page();

            }
        }
        throw new RuntimeException("failed to open the report 4 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report5IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report5).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport5Page();

            }
        }
        throw new RuntimeException("failed to open the report5 page check the page manually \n may bepage load Times Out or Publish Issues ");
    }
    public boolean report6IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report6).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport6Page();

            }
        }
        throw new RuntimeException("failed to open the report6 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report7IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report7).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport7Page();

            }
        }
        throw new RuntimeException("failed to open the report7 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report8IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report8).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport8Page();

            }
        }
        throw new RuntimeException("failed to open the report 8 page check the page manually \n may bepage load Times Out or Publish Issues");
    }

    public boolean report9IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report9).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport9Page();

            }
        }
        throw new RuntimeException("failed to open the report 9 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report10IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report10).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport10Page();

            }
        }
        throw new RuntimeException("failed to open the report 10 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report11IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report11).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport11Page();

            }
        }
        throw new RuntimeException("failed to open the report 11 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report12IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report12).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport12Page();

            }
        }
        throw new RuntimeException("failed to open the report 12 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report13IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report13).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport13Page();

            }
        }
        throw new RuntimeException("failed to open the report 13 page check the page manually \n may bepage load Times Out or Publish Issues ");
    }
    public boolean report14IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report14).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport14Page();

            }
        }
        throw new RuntimeException("failed to open the report 14 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report15IsDisplayed()
    {
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report15).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport15Page();

            }
        }
        throw new RuntimeException("failed to open the report 15 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report16IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report16).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport16Page();

            }
        }
        throw new RuntimeException("failed to open the report 16 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report17IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report17).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport17Page();

            }
        }
        throw new RuntimeException("failed to open the report 17 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report18IsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report18).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport18Page();

            }
        }
        throw new RuntimeException("failed to open the report 18 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report19IsDisplayed()
    {
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report19).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport19Page();

            }
        }
        throw new RuntimeException("failed to open the report 19 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report51IsDisplayed()
    {
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report51).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport51Page();

            }
        }
        throw new RuntimeException("failed to open the report 51 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report39IsDisplayed()
    {
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report39).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport39Page();

            }
        }
        throw new RuntimeException("failed to open the report 39 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report47IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report47).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport47Page();

            }
        }
        throw new RuntimeException("failed to open the report 47 page check the page manually \n may bepage load Times Out or Publish Issues");
    }
    public boolean report49IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report49).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport49Page();

            }
        }
        throw new RuntimeException("failed to open the report 49 page check the page manually \n may bepage load Times Out or Publish Issues ");
    }
    public boolean report50IsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(report50).isDisplayed();
            }
            catch (Exception e) {
                System.out.println("retrying open the report ");
                navigateToReport50Page();

            }
        }
        throw new RuntimeException("failed to open the report 50 page check the page manually \n may bepage load Times Out or Publish Issues");
    }





}
