package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;

public class Examination {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait ;
    public Examination(WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement waitForClickableElement(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator)) ;
    }
    public WebElement waitForVisibilityElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) ;
    }
    public WebElement waitForPresenceElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) ;
    }



    public Examination navigateToExaminationPage(){
        int maxAttempt = 3 ;
        for (int attempt=0; attempt<maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getExaminationPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to examination page url ...");
            }
        }
        throw new RuntimeException("page load Times Out after" +maxAttempt);
    }

    // Define locators for web elements

    private final By receiptNotifySearch = By.xpath("//input[@id=\"BtnReceiptNotify\"]");
    private final By receiptNotifySearchBtn=By.xpath("//*[@class=\" btn btn-default \" and contains(@value,\"بـحـث\")]");
    private final By receiptNotifySearchResultParent = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/div[4]/table/tbody/tr[1]/td[5]");
    private final By receiptNotifySearchResultChild = By.tagName("a");
    private final By technicalMemberSearch= By.xpath("//input[@id=\"LKEmployeesIDSearch\"]");
    private final By technicalMemberSearchBtn=By.xpath("//*[@id=\"FormSearchLKEmployees\"]/div[1]/div[3]/input");
    private final By technicalMemberSearchResultParent = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[4]");
    private final By technicalMemberSearchResultChild = By.tagName("a");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By  okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage= By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");


    // Method to interact with receipt notify
    public Examination clickOnReceiptNotify() throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt =0 ; attempt<maxAttempt; attempt++) {
            try {
                WebElement receiptNotify = waitForClickableElement(receiptNotifySearch);
                receiptNotify.click();

                WebElement receiptNotifySearch = waitForClickableElement(receiptNotifySearchBtn);
                receiptNotifySearch.click();

                WebElement parent = waitForPresenceElement(receiptNotifySearchResultParent);
                List<WebElement> child = parent.findElements(receiptNotifySearchResultChild);
                child.get(0).click();
                return this;
            } catch (Exception e) {
                System.out.println("Retrying click on receipt notify search btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
            }
        }
        throw new RuntimeException("Failed to click on receipt notify search btn ");
    }

    // Method to interact with technical member
    public Examination clickOnTechnicalMember()throws InterruptedException

    {
        WebElement technicalMember = waitForClickableElement(technicalMemberSearch);
        technicalMember.click();

        WebElement technicalMemberSearch = waitForClickableElement(technicalMemberSearchBtn);
        technicalMemberSearch.click();

        WebElement parent = waitForPresenceElement(technicalMemberSearchResultParent);
        List<WebElement>child = parent.findElements(technicalMemberSearchResultChild);
        child.get(0).click();
        Thread.sleep(2000);
        return this ;
    }

    // Method to interact with save button

    public Examination clickOnSaveBtn(){

        WebElement save = waitForClickableElement(saveBtn);
        save.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();


        return this;
    }
    public boolean getSuccessMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

// Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//*[@id=\"tblDataTableClient\"]/tbody");

    public Examination clickOnSearchTab()throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt=0; attempt<maxAttempt; attempt++) {
            try {
                //wait.until(ExpectedConditions.elementToBeClickable(searchTab)).click();
                //   JavascriptExecutor js = (JavascriptExecutor) driver;
                //  js.executeScript("window.scrollBy(0, 200);");
                WebElement element = waitForClickableElement(searchTab);

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();

                Thread.sleep(1200);

                return this;
            } catch (Exception e) {
                System.out.println("Exception occured " + e.getMessage());
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying click...");

            }
        }
        throw new RuntimeException("Failed to click on search tab after " + maxAttempt + " attempts");

    }
    public Examination clickOnSearchBtn()throws InterruptedException{
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement tab =waitForClickableElement(searchBtn);
                tab.click();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 200);");

                return this;
            } catch (Exception e) {
                // Refresh the page
                System.out.println("Page refreshed. Retrying click on search btn...");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab();
            }
        }
        // If max attempts reached without success, throw a custom exception
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
    }
    public boolean searchResultIsDisplayed() throws InterruptedException{
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            }
            catch (Exception e){
                System.out.println("retrying.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

            }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxRetry + " attempts");
    }


// Edit and Delete Function
private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[5]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public Examination clickOnEditBtn() throws InterruptedException{
        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement>child = parent.findElements(editBtnChild);
        child.get(0).click();

        Thread.sleep(2000);

        return this;

    }
    public Examination scrollDown(){
        JavascriptExecutor js =(JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,400);");

        return this;
    }


    public Examination clickOnEditSaveBtn()throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();
        Thread.sleep(1000);
        WebElement ok = waitForClickableElement(okBtn);
        ok.click();
        Thread.sleep(1000);
        return this;

    }

    public Examination clickOnDeleteBtn() {

        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(1).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this ;
    }
    public boolean getDeleteSuccessMessage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
            } catch (Exception e) {
                System.out.println("Retrying assert delete message");
            }
        }
        throw new RuntimeException("failed to assert delete message ") ;

    }





}
