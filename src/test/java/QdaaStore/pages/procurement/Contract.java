package QdaaStore.pages.procurement;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Contract {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public Contract (WebDriver driver){
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
    public Contract navigateToContractPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getContractPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Contract page url ...");
            }
        }
        throw new RuntimeException("page load Times Out after" + maxAttempt);
    }
    private boolean isElementDisplay(By locator){
        try {
            return waitForVisibilityElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1");


    public Contract selectTypeOfContract(boolean type) throws InterruptedException{

        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                if (!type) {
                    WebElement contractType = waitForClickableElement(contractWithoutPurOrderBtn);
                    Actions actions = new Actions(driver);
                    actions.moveToElement(contractType).click().build().perform();
                }
                return this;
            }
            catch (Exception e){
                System.out.println("Retrying select type of contract");
                driver.navigate().refresh();
                Thread.sleep(3000);

            }
        }
        throw new RuntimeException(" failed to select type of contract");
    }


    private final By pageIsDisplayed= By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1/i");

    private final By contractWithPurOrderBtn= By.xpath("//*[@id=\"rdwithpurordercontract\"]");
    private final By contractWithoutPurOrderBtn= By.xpath("//*[@id=\"FormAddOrEdit\"]/div[1]/div[1]/div/label[3]");
    private final By selectPurQuoteNumber = By.xpath("//*[@id=\"btnPurQuoteComparisonID\"]");
    private final By purQuoteSearchBtn = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[7]/div/div/div[2]/form/div[5]/input");
    private final By selectParent = By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[7]/div/div/div[2]/form/div[6]/table/tbody/tr/td[5]/a");
    private final By selectChild = By.tagName("a");
    private final By selectSuppliers1 = By.xpath("//div[@id=\"WithPurOrderdiv\"]//span[@id]");
    private final By selectSuppliers2 = By.xpath("//div[@id=\"WithoutPurOrderdiv\"]//span[@id]");

    private final By selectStore = By.xpath("//*[@id=\"select2-StoreID-container\"]");
    private final By searchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectSuppliersParent = By.xpath("//*[@id=\"select2-SupplierID-results\"]");
    private final By selectSuppliersChild = By.tagName("li");
    private final By contractSubject = By.xpath("//*[@id=\"Subject\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By itemNumber= By.xpath("//*[@id=\"Dtl_ItemID\"]");
    private final By selectUnit = By.xpath("//*[@id=\"UnitID_ForItem\"]");
    private final By itemQty = By.xpath("//*[@id=\"Dtl_Item_Qty\"]");
    private final By itemPrice= By.xpath("//*[@id=\"Dtl_Price\"]");
    private final By addBtn = By.xpath("//*[@id=\"btnAddNewItem\"]");

    public Contract selectPurQuoteNumber() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement purQuote = waitForClickableElement(selectPurQuoteNumber);
                purQuote.click();
                Thread.sleep(1000);
                WebElement searchBtn = waitForClickableElement(purQuoteSearchBtn);
                searchBtn.click();
                Thread.sleep(3000);

                WebElement parent =  waitForPresenceElement(selectParent);
                parent.click();
                Thread.sleep(2000);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting PurQuoteNumber");
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
        }
        throw new RuntimeException("failed selecting PurQuoteNumber after " + maxAttempt + "Attempt");

    }

    public Contract selectSupplier1() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectSuppliers1);
                Actions actions = new Actions(driver);
                actions.moveToElement(store).click().build().perform();
                Thread.sleep(1000);

                waitForPresenceElement(selectSuppliersParent);
                WebElement parent = driver.findElement(selectSuppliersParent);
                List<WebElement> childs= parent.findElements(selectSuppliersChild);
                childs.get(1).click();
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting supplier 1");
            }
        }
        throw new RuntimeException("failed selecting supplier 1 after " +maxAttempt);
    }
    public Contract selectSupplier2() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectSuppliers2);
                Actions actions = new Actions(driver);
                actions.moveToElement(store).click().build().perform();
                Thread.sleep(1000);

                waitForPresenceElement(selectSuppliersParent);
                WebElement parent = driver.findElement(selectSuppliersParent);
                List<WebElement> childs= parent.findElements(selectSuppliersChild);
                childs.get(1).click();
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting supplier 2");
            }
        }
        throw new RuntimeException("failed selecting supplier after " +maxAttempt);
    }

    public Contract enterContractSubject(){
        WebElement subject = waitForClickableElement(contractSubject);
        subject.sendKeys("123");
        return this ;

    }

    public Contract clickOnSaveBtn() throws InterruptedException{
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

    public Contract selectStore(String storeName) throws InterruptedException {
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

    public Contract addItem(String itemNum, String itemQTYs , String prices ) throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {

                WebElement itemNumm = waitForClickableElement(itemNumber);
                itemNumm.sendKeys(itemNum, Keys.ENTER);
                Thread.sleep(1000);

                Select select = new Select(waitForClickableElement(selectUnit));
                select.selectByValue("2");

                WebElement qty = waitForClickableElement(itemQty);
                qty.clear();
                qty.sendKeys(itemQTYs);

                WebElement price = waitForClickableElement(itemPrice);
                price.clear();
                price.sendKeys(prices);

                WebElement btnAdd = waitForClickableElement(addBtn);
                btnAdd.click();
                Thread.sleep(1500);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 400);");

                return this;
            }
            catch (Exception e){
                System.out.println("try add item and click on btn ");
            }}
        throw new RuntimeException("failed to add item and btn chech the test data");
    }

    // Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-info btn-3d \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public Contract clickOnSearchTab()throws InterruptedException{
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
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");

    }
    public Contract clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Actions actions = new Actions(driver);
                actions.moveToElement(search).click().build().perform();

                //JavascriptExecutor js = (JavascriptExecutor) driver;
              //  js.executeScript("window.scrollBy(0,250);");
                Thread.sleep(2500);

                if(isElementDisplay(searchData)){
                    return this;
                }
            } catch (Exception e) {
                // Refresh the page
                System.out.println("Page refreshed. Retrying click on search btn..." +e.getMessage());
                navigateToContractPage();
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


    public Contract clickOnEditBtn() throws InterruptedException{
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


    public Contract clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        Thread.sleep(2000);
        return this;    }

    public Contract clickOnDeleteBtn() throws InterruptedException {
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);

                List<WebElement> child = parent.findElements(editBtnChild);
                child.get(1).click();

                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();

                WebElement ok = waitForClickableElement(okBtn);
                ok.click();
                SoftAssert softAssert = new SoftAssert();

                softAssert.assertTrue(getDeleteSuccessMessage());

                return this;
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

    public boolean getEditSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(editSuccessMessage)).isDisplayed();
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }

    public Contract scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700);");
        return this ;
    }
    public Contract scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return this ;
    }
    public Contract scrollDownForAddItem(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
        return this ;
    }

    public Contract scrollDownAfterContractSubject(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700);");
        return this ;
    }








































}
