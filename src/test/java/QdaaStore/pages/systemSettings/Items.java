package QdaaStore.pages.systemSettings;

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

public class Items {
    private final WebDriver driver ;
   private final FluentWait<WebDriver> wait ;
    public Items (WebDriver driver){
        this.driver=driver;
        this.wait = new FluentWait<>(driver)
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

    private final By chooseItemClassificationBtn = By.xpath("//span[@class=\"input-group-btn\"]//a[contains(text(),\"إختر فئة الصنف\")]");
    private final By searchBoxInsideChoosingClassificationModal=By.xpath("//input[@id=\"ItemName\"]");
    private final By searchBtnInsideChoosingClassificationModal=By.xpath("//input[@value=\"بحث\"]");
    private final By classificationType = By.xpath("//i[contains(@class, 'glyphicon-folder-open')]/a[contains(text(), 'سيارات (02)')]");
    //Add new Item
    public Items navigateToItemsPage() throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getItemsPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Items page url ...");
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
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1");

    public Items chooseItemClassification(){
        wait.until(ExpectedConditions.elementToBeClickable(chooseItemClassificationBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxInsideChoosingClassificationModal)).sendKeys("سيارات");
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnInsideChoosingClassificationModal)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(classificationType)).click();
        return this ;
    }
    private final By itemName = By.xpath("//input[@id=\"Name\"]");
    private final By itemType = By.xpath("//select[@id=\"ItemType\"]");
    private final By hasSerial = By.xpath("//input[@id=\"HasSerial\"]");
    private final By units = By.xpath("//select[@id=\"UnitID_\"]");
    private final By addUnit = By.xpath("//input[@id=\"btnAddNewItemItemsUnits\"]");

    public Items enterItemName(String itemNames){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName)).sendKeys(itemNames);
        return this ;
    }
    public Items chooseItemType(){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(itemType))));
        select.selectByVisibleText("مستديم");
        return this ;
    }
    public Items chooseItemHasSerial(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hasSerial)).click();
        return this ;

    }
    public Items chooseUnit(){
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(units))));
        select.selectByIndex(2);
        wait.until(ExpectedConditions.elementToBeClickable(addUnit)).click();
        return this;

    }
    private final By  parentCarStore = By.xpath("//*[@id=\"divItemDtlList\"]/table/tbody/tr[4]");
    private final By  childCarStore = By.tagName("td");
    private final By  saveBtn = By.xpath("//input[@value=\"حفظ\"]");
    private final By  okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage= By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    public Items chooseStore() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement parent = wait.until(ExpectedConditions.visibilityOf(driver.findElement(parentCarStore)));
                List<WebElement> child = parent.findElements(childCarStore);
                child.get(0).click();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,400);");
                return this;
            } catch (Exception e) {
                System.out.println("Retrying chooseStore ");
            }
        }
        throw new RuntimeException(" failed to Retrying chooseStore after all attempt");
    }
    public Items clickOnSaveBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement saveButton = waitForClickableElement(saveBtn);
                saveButton.click();
                Thread.sleep(1500);

                WebElement okButton = waitForClickableElement(okBtn);
                okButton.click();
                SoftAssert softAssert=new SoftAssert();
                softAssert.assertTrue(getSuccessMessage());
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

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();

    }

    // Search Function
    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public Items clickOnSearchTab()throws InterruptedException{
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
    public Items clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                // Actions actions = new Actions(driver);
                // actions.moveToElement(search).click().build().perform();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", search);
                search.click();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,180);");
                Thread.sleep(3500);
                if (isElementDisplay(searchData)){
                    return this ;
                }

            } catch (Exception e) {
                // Refresh the page
                System.out.println("Page refreshed. Retrying click on search btn...");
                driver.navigate().refresh();
                Thread.sleep(3500);
                clickOnSearchTab();
                scrollDownForSearch();

            }
        }
        // If max attempts reached without success, throw a custom exception
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
    }
    public Items scrollDownForSearch()throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250);");
        Thread.sleep(1000);

        return this;
    }
    public boolean searchResultIsDisplayed(){
        int maxRetry = 3;
        for (int retry = 0; retry < maxRetry; retry++) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            }
            catch (Exception e){
                System.out.println("retrying searchResultIsDisplayed.....");

            }
        }
       throw new RuntimeException("failed to find search results element after " + maxRetry);
    }

    //Edit and Delete Function
    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]");
    private final By  editBtnChild = By.tagName("a");
    private final By editMaxQty = By.xpath("//input[@id=\"MaxQntyForRequest\"]");
    private final By  editBtn = By.xpath("//input[@id=\"btnSave\"]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");



    public Items clickOnEditBtn() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                WebElement parent = waitForVisibilityElement(editBtnParent);
                List<WebElement> child = parent.findElements(editBtnChild);
                WebElement elemnt = child.get(0);

                wait.until(ExpectedConditions.elementToBeClickable(elemnt)).click();

                Thread.sleep(3000);

                return this;
            }
            catch (Exception e){
                System.out.println("Re trying to click on edit btn ");
                driver.navigate().refresh();
                Thread.sleep(2500);
                clickOnSearchTab();
                clickOnSearchBtn();
                scrollDownForSearch();
            }}
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }


    public Items editMaxQty(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(editMaxQty)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(editMaxQty)).sendKeys("900");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
        return this;
    }
    public Items scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900);");
       return this ;
    }
    public Items clickOnEditSaveBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
                Thread.sleep(1500);
                wait.until(ExpectedConditions.visibilityOfElementLocated(okBtn)).click();
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(getSuccessMessage());

                return this;
            } catch (Exception e) {
                System.out.println("Retrying click on edit save btn ");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab();
                clickOnSearchBtn();
                clickOnEditBtn();
                editMaxQty();
            }
        }
        throw new RuntimeException(" failed to click on save btn after "+maxAttempt+ " attempt");

    }

    public Items clickOnDeleteBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editBtnParent));
        WebElement parent = driver.findElement(editBtnParent);
        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(1).click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("الصنف مستخدم في احدي العمليات الاساسية لذلك لا يمكن الحذف");
        }
        return this;
    }
    public boolean getDeleteSuccessMessage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage)).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying find delete success message ");
            }
        }
        throw new RuntimeException("failed to find delete success message");
    }










































}
