package QdaaStore.pages.mainOperations;

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

public class BalanceAdjustment {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public BalanceAdjustment (WebDriver driver){
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
    public BalanceAdjustment navigateToBalanceAdjustmentrPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getBalanceAdjustmentPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to BalanceAdjustment page url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + "attempts");
    }
    private boolean isElementDisplay(By locator) {
        try {
            return waitForVisibilityElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6");


    private final By selectStoreName= By.xpath("//select[@id=\"StoreID\"]");
    public BalanceAdjustment selectSoreName(String storeName) {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                Select select = new Select(waitForClickableElement(selectStoreName));
                select.selectByVisibleText(storeName);
                Thread.sleep(2000);
                return this;
            }
            catch(Exception e){
                System.out.println("Retrying  selecting Store name");
                navigateToBalanceAdjustmentrPage();
            }
        }
        throw new RuntimeException("failed selecting Store name after " +maxAttempt);
    }

    public BalanceAdjustment scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250);");
        return this ;
    }
    public BalanceAdjustment scrollDownForAddItem(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550);");
        return this ;
    }
    public BalanceAdjustment scrollDownForsaveBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250);");
        return this ;
    }

    // Add an Items
    private final By itemNumber= By.xpath("//*[@id=\"Dtl_ItemID\"]");
    private final By adjustmentQty= By.xpath("//*[@id=\"Dtl_AdjustmentQuantity\"]");
    private final By adjustmentType= By.xpath("//*[@id=\"DDLAdjustmentTypeID\"]");
    private final By addBtn = By.xpath("//*[@id=\"btnAddNewItem\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");
    private final By currentBalance=By.xpath("//*[contains(@id,\"QuantityBookBalance_\") and @class=\"form-control text-box single-line ng-pristine ng-untouched ng-valid ng-not-empty\"]");
    private final By actualBAlance=By.xpath("//*[contains(@id,\"QuantityActualbalance_\") and @type=\"text\"]");
    private final By adjustmntQty=By.xpath("//*[contains(@id,\"AdjustmentQuantity_\") and @type=\"number\"]");
    private final By adjustmntItemWanted=By.xpath("//*[@id=\"FormAddOrEdit_BalanceAdjustmentDtl\"]/div[1]/div[1]/span");
    private final By adjustmntItemQtyWanted=By.xpath("//*[@id=\"Dtl_AdjustmentQuantity_Error\"]");
    private final By adjustmnttypeWanted=By.xpath("//*[@id=\"FormAddOrEdit_BalanceAdjustmentDtl\"]/div[3]/div[3]/span");


    public BalanceAdjustment enterItemNum(String itemNumbers ) throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement itemNum = waitForClickableElement(itemNumber);
                itemNum.clear();
                itemNum.sendKeys(itemNumbers, Keys.ENTER);
                Thread.sleep(2000);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying enter ItemNum");
            }
        }
        throw new RuntimeException("failed to enter ItemNum ");
    }

    public BalanceAdjustment enterAdjustmentQty( String adjustmntQty)throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try{
            WebElement qty = waitForClickableElement(adjustmentQty);
            qty.clear();
            qty.sendKeys(adjustmntQty);
             Thread.sleep(2000);
             return this;
            } catch (Exception e) {
                System.out.println("Retrying enter AdjustmentQty");
            }
        }
        throw new RuntimeException("failed to  enter AdjustmentQty ");
    }

        public BalanceAdjustment enterAdjustmentType(String adjstmntType) throws InterruptedException{
            int maxAttempt = 3;
            for (int attempt = 0; attempt < maxAttempt; attempt++) {
                try {
                    Select select = new Select(waitForClickableElement(adjustmentType));
                    select.selectByValue(adjstmntType);
                    Thread.sleep(2500);
                    return this;
                }
                catch (Exception e) {
                    System.out.println("Retrying  enter adjustmentType");
                }
            }
            throw new RuntimeException("failed to enter adjustmentType ");
     }
    public BalanceAdjustment clickOnAddBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement btnAdd = waitForClickableElement(addBtn);
                btnAdd.click();
                Thread.sleep(3500);

                // Check if the necessary elements are displayed and interact if they are
                if (isElementPresent(adjustmntItemWanted) || isElementPresent(adjustmntItemQtyWanted) || isElementPresent(adjustmnttypeWanted)) {
                    enterItemNum("199")
                            .enterAdjustmentQty("1")
                            .enterAdjustmentType("1");
                    continue; // Retry the click after re-entering the details
                }

                return this; // Exit if the button click is successful and the elements are not displayed
            } catch (Exception e) {
                System.out.println("Retrying click on AddBtn: " + e.getMessage());
                // Optionally re-enter the details before retrying the click
                enterItemNum("199")
                        .enterAdjustmentQty("1")
                        .enterAdjustmentType("1");
            }
        }
        throw new RuntimeException("Failed to click on AddBtn after " + maxAttempt + " attempts");
    }

    private boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public BalanceAdjustment clickOnSaveBtn() throws InterruptedException{

        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                Thread.sleep(2500);
                WebElement okButton = waitForClickableElement(okBtn);
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(okButton).click().build().perform();
                Thread.sleep(2500);
                return this;
            }
            catch (Exception e){
                System.out.println("Retrying click on save btn " + e.getMessage());
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

    public BalanceAdjustment clickOnFixedBtn()throws InterruptedException {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();

        Thread.sleep(1000);

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this ;
    }
    public BalanceAdjustment clickOnNotFixedBtn() {
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

    public int   getCurrentBalance() {
        WebElement qty1 = waitForVisibilityElement(currentBalance);
        String currentBalanceText = qty1.getText();
        int currentBalanceNum = Integer.parseInt(currentBalanceText);
        System.out.println(currentBalanceNum);
        return currentBalanceNum;
    }
    public int getActualBalance() {
        WebElement qty2 = waitForVisibilityElement(actualBAlance);
        String actualBalanceText = qty2.getText();
        int actualBalanceNum = Integer.parseInt(actualBalanceText);
        System.out.println(actualBalanceNum);
        return actualBalanceNum;
    }
    public int getAdjstmntQty() {
        WebElement qty3 = waitForVisibilityElement(adjustmntQty);
        String adjstmntQtyText = qty3.getText();
        int adjstmntQtyNum = Integer.parseInt(adjstmntQtyText);
        System.out.println(adjstmntQtyNum);
        return adjstmntQtyNum;

    }
    public int getTotal(){
        int total =
              getCurrentBalance() + getActualBalance() ;
        System.out.println(total);
        return total ;
    }

    // Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-info btn-3d \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public BalanceAdjustment clickOnSearchTab()throws InterruptedException{
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
    public BalanceAdjustment clickOnSearchBtn() throws InterruptedException{
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
    public boolean searchResultIsDisplayed() throws InterruptedException {
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying display search results.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxRetry + " attempts");

    }

    // Edit and Delete Function

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[4]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public BalanceAdjustment clickOnEditBtn() throws InterruptedException{
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
    public BalanceAdjustment scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");
        return this ;
    }

    public BalanceAdjustment clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public BalanceAdjustment clickOnDeleteBtn() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++) {
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
                    Assert.assertTrue(getDeleteSuccessMessage());

                } catch (Exception e) {
                    System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
                }
                return this;
            } catch (Exception e) {
                System.out.println("Re trying to click on delete btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
            }
        }
        throw new RuntimeException("Failed to click on delete btn after all attempt");
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }










}
