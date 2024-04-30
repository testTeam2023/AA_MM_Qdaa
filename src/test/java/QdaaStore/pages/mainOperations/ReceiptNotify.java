package QdaaStore.pages.mainOperations;

import QdaaStore.pages.procurement.PurQuoteRequest;
import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ReceiptNotify  {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait ;
    public ReceiptNotify(WebDriver driver){
        this.driver=driver ;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
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
    public ReceiptNotify navigateToReceiptNotifyPage() throws InterruptedException{
        int maxAttempt = 3 ;
      for (int attempt=0; attempt<maxAttempt; attempt++) {
          try {
              driver.get(ConfigUtils.getInstance().getReceiptNotifyPage());
              driver.navigate().refresh();
              Thread.sleep(3000);
              return this;
          } catch (Exception e) {
              driver.navigate().refresh();
              System.out.println("Page refreshed. Retrying navigate to receipt notify page url ...");
          }
      }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By storeName = By.xpath("//span[@id=\"select2-StoreID-container\"]");
    private final By searchForStore = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectStore=By.xpath("//*[@class=\"select2-results__options\"]//li[contains(text(),\"الاجهزة الالكترونية\")]");
    private final By suppliers=By.xpath("//*[@id=\"select2-Supp_ID-container\"]");
    private final By selectSupplierParent = By.xpath("//ul[@id=\"select2-Supp_ID-results\"]");
    private final By selectSupplierChild=By.tagName("li");
    private final By receiverName=By.xpath("//span[@id=\"select2-EmployeeId_Recieved-container\"]");
    private final By selectReceiverParent = By.xpath("//ul[@id=\"select2-EmployeeId_Recieved-results\"]");
    private final By selectReceiverChild=By.tagName("li");

    public ReceiptNotify addStoreName( String storeNAme) throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(storeName)).click();
                Thread.sleep(2500);
                wait.until(ExpectedConditions.elementToBeClickable(searchForStore)).sendKeys(storeNAme, Keys.ENTER);
                return this;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying");
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
        }
        throw new RuntimeException("failed to find elemnt after "+maxAttempt);
    }
    public ReceiptNotify addSupplierName(){
        int maxAttempt = 5;
        int attempt = 0;
        while (attempt<maxAttempt){
            try {

                wait.until(ExpectedConditions.elementToBeClickable(suppliers));
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(suppliers)).click().build().perform();
                WebElement parent = driver.findElement(selectSupplierParent);
                List<WebElement> child = parent.findElements(selectSupplierChild);
                child.get(1).click();
                return this;
            }
            catch (Exception e){
                System.out.println("retrying");
                attempt++;
            }
        }
            throw new RuntimeException("failed to cath elemnt after "+maxAttempt);
    }
    public ReceiptNotify addReceiverName(){
        wait.until(ExpectedConditions.elementToBeClickable(receiverName)).click();
        WebElement parent = driver.findElement(selectReceiverParent);
        List<WebElement> child=parent.findElements(selectReceiverChild);
        child.get(3).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");
        return this ;
    }
    // Add an Items

    private final By itemNo = By.xpath("//input[@id=\"ItemID\"]");
    private final By itemQty = By.xpath("//input[@id=\"Quantity\"]");
    private final By itemPrice = By.xpath("//input[@id=\"Price\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItem\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By  okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage= By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");

    public ReceiptNotify addItems (String itemNum,String qty, String price) throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt=0; attempt<maxAttempt; attempt++) {
            try {

                wait.until(ExpectedConditions.elementToBeClickable(itemNo)).clear();
                wait.until(ExpectedConditions.elementToBeClickable(itemNo)).sendKeys(itemNum, Keys.ENTER);
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(itemQty)).clear();
                wait.until(ExpectedConditions.elementToBeClickable(itemQty)).sendKeys(qty);
                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(itemPrice)).clear();
                wait.until(ExpectedConditions.elementToBeClickable(itemPrice)).sendKeys(price);
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
                Thread.sleep(1200);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 400);");
                return this;
            } catch (Exception e) {
                System.out.println("retrying add items");
            }
        }
            throw new RuntimeException("failed to add item after " +maxAttempt +"attempts");
        }

    public ReceiptNotify clickOnSaveBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement saveButton = waitForClickableElement(saveBtn);
                Actions actions = new Actions(driver);
                actions.moveToElement(saveButton).click().build().perform();
                Thread.sleep(1500);
                WebElement okButton = waitForClickableElement(okBtn);
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(okButton).click().build().perform();
                Thread.sleep(1500);
                return this;
            }
            catch (Exception e){
                System.out.println("Retrying click on save btn ");
                handleUnexpectedAlert();
            }
        }
        throw new RuntimeException(" failed to click on save btn after "+maxAttempt+ " attempt");
    }
    private void handleUnexpectedAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.dismiss();
        } catch (Exception e) {
            // If no alert is present, continue
            System.out.println("No alert present. Continuing...");
        }
    }
    public boolean getSuccessMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    // Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-info btn-3d \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public ReceiptNotify clickOnSearchTab()throws InterruptedException{
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
    public ReceiptNotify clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Actions actions = new Actions(driver);
                actions.moveToElement(search).click().build().perform();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 200);");
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                // Refresh the page
                System.out.println("Page refreshed. Retrying click on search btn...");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
            }
        }
        // If max attempts reached without success, throw a custom exception
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
    }
    public boolean searchResultIsDisplayed() throws InterruptedException{

        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying display Search Results.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find search results element after " + maxRetry +" Attempt");    }


    // Edit and Delete
    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[9]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");
    private final By  messageError = By.xpath("//*[@id=\"div-error-modal\"]//div[contains(text(),\"لا يمكن الحذف والإشعار مستخدم فى مذكرة إستلام\")]");
    private final By  errorOkBtn = By.xpath("//button[@id=\"btn-error-modal\"]");

    public ReceiptNotify clickOnEditBtn() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);
                List<WebElement> child = parent.findElements(editBtnChild);
                child.get(0).click();

                Thread.sleep(2000);

                return this;
            }
            catch (Exception e){
                System.out.println("Re trying to click on edit btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }
    public ReceiptNotify scrollDown(){
        JavascriptExecutor js =(JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,200);");
        return this;
    }


    public ReceiptNotify scrollToEnd(){
        JavascriptExecutor js =(JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,700);");
        return this;
    }

    public ReceiptNotify clickOnEditSaveBtn(){
            wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(okBtn)).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getSuccessMessage());

        return this;

    }

    public ReceiptNotify clickOnDeleteBtn() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);

                List<WebElement> child = parent.findElements(editBtnChild);
                child.get(1).click();

                try {
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    alert.accept();

                    WebElement ok = waitForClickableElement(okBtn);
                    ok.click();
                    System.out.println(getDeleteSuccessMessage());

                } catch (Exception e) {
                    System.out.println("لا يمكن الحذف مستخدم في احد العمليات الاساسية");
                }
                return this ;
            }
            catch (Exception e){
                System.out.println("Re trying to click on delete btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on delete btn after all attempt");

    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }
}
