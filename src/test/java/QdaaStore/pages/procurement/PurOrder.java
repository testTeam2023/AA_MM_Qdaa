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

public class PurOrder {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public PurOrder (WebDriver driver){
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
    public PurOrder navigateToPurOrderPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getPurOrderPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to PurOrder page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By selectDepartment = By.xpath("//*[@id=\"select2-DepartmentID-container\"]");
    private final By searchDepartmentField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    public PurOrder selectDepartment(String DepartmentName) throws InterruptedException {
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

    public PurOrder scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return this ;
    }
    // Add Items
    private final By itemType= By.xpath("//*[@id=\"FormAddOrEdit_PurOrderDtl\"]/div[1]/div[1]/select");
    private final By itemNumber= By.xpath("//*[@id=\"Dtl_ItemID\"]");
    private final By selectUnit = By.xpath("//*[@id=\"UnitID_ForItem\"]");
    private final By itemQty = By.xpath("//*[@id=\"Dtl_Item_Qty\"]");
    private final By addBtn = By.xpath("//*[@id=\"btnAddNewItem\"]");
    private final By itemName= By.xpath("//*[@id=\"FormAddOrEdit_PurOrderDtl\"]/div[2]/div[1]/input");
    private final By unit = By.xpath("//*[@id=\"UnitID_All\"]");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");

    public PurOrder addItem(String itemTypes ,String itemNum, String itemQTYs ) throws InterruptedException {

        switch (itemTypes) {

            case "دليل الاصناف" -> {
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

                        WebElement btnAdd = waitForClickableElement(addBtn);
                        btnAdd.click();
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollBy(0,350);");
                        Thread.sleep(2000);
                        return this;
                    } catch (Exception e) {
                        System.out.println("try add item and click on btn ");
                    }
                }
                throw new RuntimeException("failed to add item and btn check the test data");
            }

            case "صنف جديد" -> {
                int maxAttempt = 3;
                for (int attempt = 0; attempt < maxAttempt; attempt++) {
                    try {
                        Select select = new Select(waitForClickableElement(itemType));
                        select.selectByVisibleText(itemTypes);


                        WebElement itemNames = waitForClickableElement(itemName);
                        itemNames.clear();
                        itemNames.sendKeys("صنف جديد");

                        Select select1 = new Select(waitForClickableElement(unit));
                        select1.selectByValue("2");

                        WebElement qty = waitForClickableElement(itemQty);
                        qty.clear();
                        qty.sendKeys(itemQTYs);
                        WebElement btnAdd = waitForClickableElement(addBtn);
                        btnAdd.click();
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollBy(0,350);");
                        Thread.sleep(2000);
                        return this;
                    } catch (Exception e) {
                        System.out.println("try add item and click on btn ");
                    }
                }
                throw new RuntimeException("failed to add item and btn check the test data");
            }
            default -> throw new RuntimeException(" not supported type");
        }
    }




    public PurOrder clickOnSaveBtn() throws InterruptedException{

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
    // Search Function

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-3d btn-info \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public PurOrder clickOnSearchTab()throws InterruptedException{
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
    public PurOrder clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Actions actions = new Actions(driver);
                actions.moveToElement(search).click().build().perform();

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,200);");
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
                System.out.println("retrying.....");
                driver.navigate().refresh();
                Thread.sleep(2000);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to find search results element after" + maxRetry);

    }

    // Edit and Delete Function

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[5]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By editSuccessMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم التعديل بنجاح\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");


    public PurOrder clickOnEditBtn() throws InterruptedException{
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

    public PurOrder clickOnEditSaveBtn(){
        WebElement edit = waitForClickableElement(editBtn);
        edit.click();

        WebElement ok = waitForClickableElement(okBtn);
        ok.click();

        return this;

    }

    public PurOrder clickOnDeleteBtn() throws InterruptedException {

        int maxRetry = 5;
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
                    System.out.println(getDeleteSuccessMessage());

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

    public boolean getEditSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(editSuccessMessage)).isDisplayed();
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }

    public PurOrder scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(editBtn));
        return this ;
    }


    }
