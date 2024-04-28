package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ItemsTransfeer {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ItemsTransfeer (WebDriver driver){
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
    public ItemsTransfeer navigateToItemsTransferPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getItemsTransferPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Items transfer page url ...");
            }
        }
        throw new RuntimeException("page load Times Out after" + maxAttempt);
    }
    private final By SelectTransferType = By.xpath("//*[@id=\"TransfeerType\"]");
    private final By selectFromStore = By.xpath("//*[@id=\"select2-StoreIDFrom-container\"]");
    private final By fromStoreSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectToStore = By.xpath("//*[@id=\"select2-StoreIDTo-container\"]");
    private final By toStoreSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectStoreKeeperTo = By.xpath("//*[@id=\"select2-CuratorIDTo-container\"]");
    private final By storeKeeperSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");


    public ItemsTransfeer selectTransferType(String transferType) {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                Select select = new Select(waitForClickableElement(SelectTransferType));
                select.selectByValue(transferType);
                return this;
            }
            catch(Exception e){
                System.out.println("Retrying  selecting Transfer Type");
                driver.navigate().refresh();
            }
        }
        throw new RuntimeException("failed selecting Transfer Type after " +maxAttempt);
    }

    public ItemsTransfeer selectFromStore(String storeFrom_name) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement fromstore1 = waitForClickableElement(selectFromStore);
                fromstore1.click();
                Thread.sleep(1500);

                WebElement storeFromSearch = waitForClickableElement(fromStoreSearch);
                storeFromSearch.sendKeys(storeFrom_name, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting from - store  ");
            }
        }
        throw new RuntimeException("failed selecting from - store  after " +maxAttempt);

    }

    public ItemsTransfeer selectToStore(String store2Name) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectToStore);
                store.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(toStoreSearch);
                search.sendKeys(store2Name,Keys.ENTER);
                Thread.sleep(1500);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting To - store  ");
            }
        }
        throw new RuntimeException("failed selecting from - store  after " +maxAttempt);

    }

    public ItemsTransfeer selectStoreKeeper(String storeKeeperName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement storeKeeper = waitForClickableElement(selectStoreKeeperTo);
                storeKeeper.click();
                Thread.sleep(1500);

                WebElement storeKeeperSearchh = waitForClickableElement(storeKeeperSearch);
                storeKeeperSearchh.sendKeys(storeKeeperName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting store keeper name");
            }
        }
        throw new RuntimeException("failed selecting store keeper name after " +maxAttempt);

    }
    public ItemsTransfeer scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return this ;
    }

    // Add an Item

    private final By itemNumber= By.xpath("//*[@id=\"Dtl_ItemID\"]");
    private final By transferQty= By.xpath("//*[@id=\"Dtl_TransQuantity\"]");
    private final By addBtn = By.xpath("//*[@id=\"btnAddNewItem\"]\n");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");

    public ItemsTransfeer addItem(String itemNumbers ,String transQty) throws InterruptedException{

        WebElement itemNum= waitForClickableElement(itemNumber);
        itemNum.sendKeys(itemNumbers,Keys.ENTER);
        Thread.sleep(1000);
        WebElement qty = waitForClickableElement(transferQty);
        qty.clear();
        qty.sendKeys(transQty);
        WebElement itemsAdd= waitForClickableElement(addBtn);
        itemsAdd.click();
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,350);") ;
        Thread.sleep(2500);
        return this ;
    }

    public ItemsTransfeer clickOnSaveBtn() throws InterruptedException{
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

    public ItemsTransfeer clickOnFixedBtn()throws InterruptedException {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();

        Thread.sleep(1000);

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this ;
    }
    public ItemsTransfeer clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            notFixedButton.click();

            Thread.sleep(1000);

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();

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
    private final By  searchBtn = By.xpath("//input[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public ItemsTransfeer clickOnSearchTab()throws InterruptedException{
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
    public ItemsTransfeer clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
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
                Thread.sleep(3000);
                clickOnSearchTab();
            }
        }
        // If max attempts reached without success, throw a custom exception
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
    }
    public boolean searchResultIsDisplayed() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                return waitForPresenceElement(searchData).isDisplayed();
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

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[4]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public ItemsTransfeer clickOnEditBtn() throws InterruptedException{
        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(0).click();

        Thread.sleep(2000);

        return this;

    }
    public ItemsTransfeer scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(notFixed));
        return this ;
    }

    public ItemsTransfeer clickOnEditSaveBtn(){
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this;

    }

    public ItemsTransfeer clickOnDeleteBtn() {

        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(1).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();
            Assert.assertTrue(getDeleteSuccessMessage());

        } catch (Exception e) {
            System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
        }
        return this ;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }









}
