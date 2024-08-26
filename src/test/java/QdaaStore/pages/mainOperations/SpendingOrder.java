package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.reporters.TestHTMLReporter;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SpendingOrder {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public SpendingOrder (WebDriver driver){
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
    public SpendingOrder navigateToSpendingOrderPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getSpendingOrderPage());
                Thread.sleep(4000);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to spending order url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
    }
    private boolean isElementDisplay(By locator){
        try {
            return waitForVisibilityElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6");

    // Select Stores, Department, Department manager and receiver name  from a list
    private final By selectStore = By.xpath("//span[@id=\"select2-StoreID_from-container\"]");
    private final By searchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By selectStoreKeeper = By.xpath("//*[@id=\"select2-StoreCuratorId-container\"]");
    private final By searchFieldForStoreKeeper = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectDepartment = By.xpath("//*[@id=\"select2-DepartmentID_to-container\"]");
    private final By searchDepartmentField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectDepartmentManger = By.xpath("//*[@id=\"select2-EmployeeID_to-container\"]");
    private final By searchDepartmentMangerField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectReceiverName=By.xpath("//*[@id=\"select2-EmployeeID_Recieved-container\"]");
    private final By searchReceiverField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    public SpendingOrder selectStore(String storeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStore);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchField);
                storeSearch.sendKeys(storeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Store");
                navigateToSpendingOrderPage();
            }
        }
        throw new RuntimeException("failed selecting Store after " +maxAttempt);

    }
    public SpendingOrder selectStoreKeeper(String storeKeeper) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectStoreKeeper);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchFieldForStoreKeeper);
                storeSearch.sendKeys(storeKeeper, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying selecting StoreKeeper");
            }
        }
        throw new RuntimeException("failed selecting StoreKeeper after " +maxAttempt);

    }
    public SpendingOrder selectDepartment(String DepartmentName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectDepartment);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchDepartmentField);
                storeSearch.sendKeys(DepartmentName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Department");
            }
        }
        throw new RuntimeException("failed selecting Department after " +maxAttempt);

    }

    public SpendingOrder selectDepartmentManager(String DepartmentManagerName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectDepartmentManger);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchDepartmentMangerField);
                storeSearch.sendKeys(DepartmentManagerName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting Department manager");
            }
        }
        throw new RuntimeException("failed selecting Department manager after " +maxAttempt);
    }
    public SpendingOrder selectReceiver(String ReceiverName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectReceiverName);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(searchReceiverField);
                storeSearch.sendKeys(ReceiverName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting receiver name");
            }
        }
        throw new RuntimeException("failed selecting receiver name after " +maxAttempt);
    }

    public SpendingOrder scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
        return this ;
    }
    public SpendingOrder scrollDownForSearch()throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);");
        return this ;
    }

    // Add items and save
    private final By itemNumberBtn= By.xpath("//*[@id=\"FormAddOrEdit_SpendingOrderDtl\"]/div[1]/div/label[4]");
    private final By itemNum = By.xpath("//*[@id=\"SearchKey\"]");
    private final By itemQty = By.xpath("//*[@id=\"OrdQuantity\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItemm\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");

    public SpendingOrder addItem(String itemNumbers ,String itemqtys) throws InterruptedException{
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement itemNumBtn = waitForClickableElement(itemNumberBtn);
                itemNumBtn.click();

                WebElement itemNumber = waitForClickableElement(itemNum);
                itemNumber.sendKeys(itemNumbers, Keys.ENTER);
                Thread.sleep(1000);

                WebElement qty = waitForClickableElement(itemQty);
                qty.clear();
                qty.sendKeys(itemqtys);

                WebElement add = waitForClickableElement(addBtn);
                add.click();
                Thread.sleep(1500);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350);");

                return this;
            }
            catch (Exception e){
                System.out.println("try add item and click on btn ");
            }}
        throw new RuntimeException("failed to add item and btn check the test data");
    }


    public SpendingOrder clickOnSaveBtn() throws InterruptedException{

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

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    public SpendingOrder clickOnFixedBtn()throws InterruptedException {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();
        Thread.sleep(1500);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        return this ;
    }
    public SpendingOrder clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            wait.until(ExpectedConditions.elementToBeClickable(notFixedButton)).click();

            Thread.sleep(1500);

            WebElement okButton = waitForClickableElement(okBtn);
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();

        }
        catch (Exception e){
            throw  new RuntimeException("زر التثبيت مفعل ");

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
    private final By  searchBtn = By.xpath("//*[@id=\"FormSearch\"]/div[1]/div[10]/input");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public SpendingOrder clickOnSearchTab()throws InterruptedException{
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
    public SpendingOrder clickOnSearchBtn() throws InterruptedException {
        int maxAttempts = 10;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Thread.sleep(1500);
                //Actions actions = new Actions(driver);
               //  actions.moveToElement(search).click().build().perform();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
               executor.executeScript("arguments[0].scrollIntoView(true);", search);
                search.click();
                Thread.sleep(3500);
                if (isElementDisplay(searchData)) {
                    return this;
                }
            } catch (Exception e ) {
                System.out.println("Element not found or stale. Retrying click on search button..."+ e.getMessage());
                navigateToSpendingOrderPage();
                clickOnSearchTab();
                scrollDownForSearch();            }
        }
        throw new RuntimeException("Failed to click on search btn after all attempts");
    }
    private void retryClickOnSearchBtn() throws InterruptedException {
        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(3500);
        clickOnSearchTab();
        scrollDownForSearch();
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
        throw new RuntimeException("failed to find element after" +maxRetry);
    }

    // Edit function

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[11]");
    private final By  editBtnChild = By.xpath(".//a[@class=\"btn btn-warning btn-xs\"]");
    private final By  DeleteBtnChild = By.xpath(".//a[@class=\"btn btn-danger btn-xs\"]");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public SpendingOrder clickOnEditBtn() throws InterruptedException{

        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);
                WebElement child = parent.findElement(editBtnChild);
                child.click();
                //  List<WebElement> child = parent.findElements(editBtnChild);
               //  WebElement elemnt =  wait.until(ExpectedConditions.elementToBeClickable(child.get(0)));
              //elemnt.click();

                Thread.sleep(3000);

                return this;
            }
            catch (Exception e){
                System.out.println("Re trying to click on edit btn " + e.getMessage());
                navigateToSpendingOrderPage();
                clickOnSearchTab();
                scrollDownForSearch();
                clickOnSearchBtn();
            }}
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }


    public SpendingOrder scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 850);");
        return this ;
    }

    public SpendingOrder clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public SpendingOrder clickOnDeleteBtn() throws InterruptedException {

        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {

                WebElement parent = waitForVisibilityElement(editBtnParent);
                WebElement child = parent.findElement(DeleteBtnChild);
                child.click();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();
            System.out.println(getDeleteSuccessMessage());

        } catch (Exception e) {
            System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
        }
        return this;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }

























}
