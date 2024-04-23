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

public class ReturnSpendingOrder {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ReturnSpendingOrder (WebDriver driver){
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
    public ReturnSpendingOrder navigateToReturnSpendingOrderPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReturnSpendingOrderPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to return spending order page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    // ----------

    private final By selectStoreName = By.xpath("//*[@id=\"StoreID_from\"]");
    private final By selectStoreKeeper = By.xpath("//*[@id=\"select2-StoreCuratorId-container\"]");
    private final By storeKeeperSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectDepartment = By.xpath("//*[@id=\"select2-SpendDepartmentID-container\"]");
    private final By departmentSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By receiverName=By.xpath("//*[@id=\"EmployeeID_Recieved\"]");

    public ReturnSpendingOrder selectStoreName() {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                Select select = new Select(waitForClickableElement(selectStoreName));
                select.selectByValue("3");
                return this;
            }
         catch(Exception e){
            System.out.println("Retrying  selecting store name");
            driver.navigate().refresh();
        }
    }
        throw new RuntimeException("failed selecting store keeper name after " +maxAttempt);
}

    public ReturnSpendingOrder selectStoreKeeper(String storeKeeperName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement storeKeeper = waitForClickableElement(selectStoreKeeper);
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

    public ReturnSpendingOrder selectDepartment(String department) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement departments = waitForClickableElement(selectDepartment);
                departments.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(departmentSearch);
                search.sendKeys(department, Keys.ENTER);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,75);");
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting department name");
            }
        }
        throw new RuntimeException("failed selecting department name after " +maxAttempt);

    }

    public ReturnSpendingOrder selectReceiverName(String receiverNames){
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement search = waitForClickableElement(receiverName);
                search.sendKeys(receiverNames, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting receiver name");
            }
        }
        throw new RuntimeException("failed selecting receiver name after " +maxAttempt);

    }
    public ReturnSpendingOrder scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        return this ;
    }

    // Add an item

    private final By itemNumberBtn= By.xpath("//*[@id=\"FormAddOrEdit_ReturnSpendingOrderDtl\"]/div[1]/div/label[4]");
    private final By itemNum = By.xpath("//*[@id=\"SearchKey\"]");
    private final By spentQty = By.xpath("//*[@id=\"Dtl_SpntQuantity\"]");
    private final By committeeRecommendation =By.xpath("//*[@id=\"DDLCauseID\"]");
    private final By addBtn = By.xpath("//input[@id=\"btnAddNewItem\"]");
    private final By recommendationQty = By.xpath("//input[contains(@id,\"CauseQuantity\")]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");
    public ReturnSpendingOrder addItem(String itemNumbers ,String spntQty,String recQty) throws InterruptedException{
        WebElement itemNumBtn= waitForClickableElement(itemNumberBtn);
        itemNumBtn.click();

        WebElement itemNumber= waitForClickableElement(itemNum);
        itemNumber.sendKeys(itemNumbers,Keys.ENTER);

        WebElement qty = waitForClickableElement(spentQty);
        qty.clear();
        qty.sendKeys(spntQty);

        Select select = new Select(waitForClickableElement(committeeRecommendation));
        select.selectByValue("1");

        WebElement add= waitForClickableElement(addBtn);
        add.click();

        WebElement qtys = waitForClickableElement(recommendationQty);
        qtys.clear();
        qtys.sendKeys(recQty);

        Thread.sleep(1500);
        return this ;
    }

    public ReturnSpendingOrder clickOnSaveBtn() throws InterruptedException{
        WebElement saveButton = waitForClickableElement(saveBtn);
        saveButton.click();
        Thread.sleep(1500);
        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();
        Assert.assertTrue(getSuccessMessage());
        Thread.sleep(1500);

        return this;
    }

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    public ReturnSpendingOrder clickOnFixedBtn()throws InterruptedException {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this ;
    }
    public ReturnSpendingOrder clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            notFixedButton.click();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            alert.accept();


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

    public ReturnSpendingOrder clickOnSearchTab()throws InterruptedException{
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
    public ReturnSpendingOrder clickOnSearchBtn() throws InterruptedException{
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
            catch (Exception e){
                System.out.println("retrying.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find element after" +maxRetry);
    }
// Edit and Delete Function

        private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public ReturnSpendingOrder clickOnEditBtn() throws InterruptedException{
        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(0).click();

        Thread.sleep(2000);

        return this;

    }
    public ReturnSpendingOrder scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(notFixed));
        return this ;
    }

    public ReturnSpendingOrder clickOnEditSaveBtn(){
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this;

    }

    public ReturnSpendingOrder clickOnDeleteBtn() {

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
            System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
        }
        return this ;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }





}
