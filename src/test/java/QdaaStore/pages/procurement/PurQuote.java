package QdaaStore.pages.procurement;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PurQuote {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public PurQuote (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresenceElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public PurQuote navigateToPurQuotePage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getPurQuotePage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to PurQuote page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By selectPurQuoteNumber = By.xpath("//*[@id=\"FormAddOrEdit\"]/div[3]/div[1]/div/span[1]/span[1]/span");

    private final By selectPurQuoteParent = By.xpath("//*[@id=\"select2-PurQuoteRequestID-results\"]");
    private final By selectPurQuoteChild = By.tagName("li");
    private final By selectSuppliers = By.xpath("//*[@id=\"select2-SupplierID-container\"]");
    private final By selectSuppliersParent = By.xpath("//*[@id=\"select2-SupplierID-results\"]");
    private final By selectSuppliersChild = By.tagName("li");
    private final By price = By.xpath("//*[contains(@id,\"Price\") and @type=\"number\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    public PurQuote selectPurQuoteNumber() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectPurQuoteNumber);
                store.click();
                Thread.sleep(1000);

                waitForPresenceElement(selectPurQuoteParent);
                WebElement parent = driver.findElement(selectPurQuoteParent);
                List<WebElement> childs= parent.findElements(selectPurQuoteChild);
                childs.get(1).click();
                Thread.sleep(1700);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting PurQuoteNumber");
                driver.navigate().refresh();
                Thread.sleep(2500);
            }
        }
        throw new RuntimeException("failed selecting PurQuoteNumber after " +maxAttempt);

    }
    public PurQuote selectSupplier() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectSuppliers);
                store.click();
                Thread.sleep(1500);

                waitForPresenceElement(selectSuppliersParent);
                WebElement parent = driver.findElement(selectSuppliersParent);
                List<WebElement> childs= parent.findElements(selectSuppliersChild);
                childs.get(1).click();
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting supplier");
                driver.navigate().refresh();
                Thread.sleep(2500);
                selectPurQuoteNumber();


            }
        }
        throw new RuntimeException("failed selecting supplier after " +maxAttempt+ " attempt");

    }
    public PurQuote scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return this ;
    }

    public PurQuote editPrice(){
        WebElement editPrice = waitForClickableElement(price);
        editPrice.clear();
        editPrice.sendKeys("250");
        return this ;

    }

    public PurQuote clickOnSaveBtn() throws InterruptedException{
        WebElement saveButton = waitForClickableElement(saveBtn);
        saveButton.click();
        Thread.sleep(1500);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getSuccessMessage());
        Thread.sleep(1500);

        return this;
    }

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    // Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-3d btn-info \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public PurQuote clickOnSearchTab()throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt=0; attempt<maxAttempt; attempt++) {
            try {
                //wait.until(ExpectedConditions.elementToBeClickable(searchTab)).click();
                //   JavascriptExecutor js = (JavascriptExecutor) driver;
                //  js.executeScript("window.scrollBy(0, 200);");
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchTab));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                Thread.sleep(2000);
                return this;
            } catch (Exception e) {
                System.out.println("Exception occured " + e.getMessage());
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying click on search tab...");

            }
        }
        throw new RuntimeException("Failed to click on search tab after " + maxAttempt + " attempts");

    }
    public PurQuote clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
                Thread.sleep(1500);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 150);");
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
    public boolean searchResultIsDisplayed() throws InterruptedException {
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {
                return waitForVisibilityElement(searchData).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying display Search Results.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find search results element after " + maxRetry +" Attempt");

    }

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By editSuccessMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم التعديل بنجاح\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");


    public PurQuote clickOnEditBtn() throws InterruptedException{
        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(0).click();

        Thread.sleep(2000);

        return this;

    }

    public PurQuote clickOnEditSaveBtn(){
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this;
    }

    public PurQuote clickOnDeleteBtn() {

        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(1).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();
        SoftAssert softAssert =new SoftAssert();

        softAssert.assertTrue(getDeleteSuccessMessage());

        return this ;

    }

    public boolean getEditSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(editSuccessMessage)).isDisplayed();
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }

    public PurQuote scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(editBtn));
        return this ;
    }

















}
