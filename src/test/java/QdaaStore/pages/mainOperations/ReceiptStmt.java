package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ReceiptStmt {

    private final WebDriver driver;
    private final FluentWait<WebDriver> wait;

    public ReceiptStmt(WebDriver driver) {
        this.driver = driver;
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


    public ReceiptStmt navigateToReceiptStmtPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReceiptStmtPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to receipt stmt page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    // Select supplier from a list
    private final By selectSuppliers = By.xpath("//span[@id=\"select2-SuppID-container\"]");
    private final By suppliersParent = By.xpath("//ul[@id=\"select2-SuppID-results\"]");
    private final By suppliersChild = By.tagName("li");

    public ReceiptStmt selectSupplier() {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement supplier = waitForClickableElement(selectSuppliers);
                supplier.click();

                WebElement results = waitForVisibilityElement(suppliersParent);

                List<WebElement> child = results.findElements(suppliersChild);
                child.get(1).click();
                Thread.sleep(2000);

                return this;
            } catch (Exception e) {
                System.out.println("retrying to select supplier");
            }
        }
            throw new RuntimeException("failed selecting supplier after "+maxAttempt) ;

            }

    // Select Stores from a list
    private final By selectStore = By.xpath("//span[@id=\"select2-StoreID-container\"]");
    private final By searchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    public ReceiptStmt selectStore(String storeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStore);
                store.click();
               // Actions actions = new Actions(driver);
               // actions.moveToElement(store).click().build().perform();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchField);
                storeSearch.sendKeys(storeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting store");
            }
        }
            throw new RuntimeException("failed selecting store after " +maxAttempt);

    }

    // Select an employee to receive the items
    private final By receiverSearch = By.xpath("//input[@id=\"LKEmployeesIDSearch\" and @class=\"btn btn-info btn-sm valid\"]");
    private final By receiverSearchBtn = By.xpath("//*[@id=\"FormSearchLKEmployees\"]/div[1]/div[3]/input");
    private final By receiverSearchResultParent = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[4]");
    private final By receiverSearchResultChild = By.tagName("a");

    public ReceiptStmt selectEmployeeName() {

        WebElement EmployeeSearchBtn = waitForClickableElement(receiverSearch);
        EmployeeSearchBtn.click();

        WebElement searchBtn = waitForClickableElement(receiverSearchBtn);
        searchBtn.click();

        WebElement results = waitForVisibilityElement(receiverSearchResultParent);

        List<WebElement> child = results.findElements(receiverSearchResultChild);
        child.get(0).click();

        return this;

    }

    public ReceiptStmt scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);");

        return this;
    }

    // Add an Item
    private final By itemNo = By.xpath("//input[@id=\"ItemID\"]");
    private final By itemQty = By.xpath("//input[@id=\"Itemquantity\"]");
    private final By itemPrice = By.xpath("//input[@id=\"Itemprice\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItem\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");


    public ReceiptStmt addItems(String itemNum, String qty, String price) throws InterruptedException {
        WebElement itemNoField = waitForClickableElement(itemNo);
        itemNoField.sendKeys(itemNum, Keys.ENTER);
        Thread.sleep(1000);
        WebElement qtyField = waitForClickableElement(itemQty);
        qtyField.clear();
        qtyField.sendKeys(qty);

        WebElement priceField = waitForClickableElement(itemPrice);
        priceField.clear();
        priceField.sendKeys(price);

        WebElement itemAdded = waitForClickableElement(addBtn);
        itemAdded.click();
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,350);") ;

        Thread.sleep(2000);
        return this;
    }

    public ReceiptStmt clickOnSaveBtn() throws InterruptedException{

        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement saveButton = waitForClickableElement(saveBtn);
                saveButton.click();
                Thread.sleep(1500);

                WebElement okButton = waitForClickableElement(okBtn);
                okButton.click();
                Assert.assertTrue(getSuccessMessage());
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

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    public ReceiptStmt clickOnFixedBtn() {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        return this ;
    }
    public ReceiptStmt clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            notFixedButton.click();

            WebElement okButton = waitForClickableElement(okBtn);
            okButton.click();

            System.out.println(notFixedMessageSuccess());
            System.out.println(notFixedBtnDisable());

        }
        catch (Exception e){
            throw new RuntimeException("زر التثبيت مفعل ");
        }
        return this ;
    }


    public boolean fixedBtnDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notFixed)).isEnabled();
    }

    public boolean notFixedBtnDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fixed)).isEnabled();
    }


    public boolean notFixedMessageSuccess(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageOfNotFixed)).isDisplayed();
    }

    // Search Function
    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public ReceiptStmt clickOnSearchTab()throws InterruptedException{
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
                System.out.println("Page refreshed. Retrying click...");

            }
        }
        throw new RuntimeException("Failed to click on search tab after " + maxAttempt + " attempts");

    }
    public ReceiptStmt clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
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
            catch (StaleElementReferenceException e){
                System.out.println("retrying.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find element after" +maxRetry);
    }

    // Edit function

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[8]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public ReceiptStmt clickOnEditBtn() throws InterruptedException{
        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement>child = parent.findElements(editBtnChild);
        child.get(0).click();

        Thread.sleep(2000);

        return this;

    }
    public ReceiptStmt scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(notFixed));
        return this ;
    }

    public ReceiptStmt clickOnEditSaveBtn(){
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this;

    }

    public ReceiptStmt clickOnDeleteBtn() {

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
            System.out.println("المحضر لا يمكن حذفة بعد التثبيت");
        }
        return this ;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }

























}
