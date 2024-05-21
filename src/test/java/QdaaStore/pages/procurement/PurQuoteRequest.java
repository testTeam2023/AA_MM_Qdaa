package QdaaStore.pages.procurement;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PurQuoteRequest {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public PurQuoteRequest (WebDriver driver){
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
    public PurQuoteRequest navigateToPurQuoteRequestPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getPurQuoteRequestPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to PurQuoteRequest page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
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

    private final By selectPurQuoteNumber = By.xpath("//*[@id=\"select2-PurOrderID-container\"]");

    private final By selectPurQuoteParent = By.xpath("//*[@id=\"select2-PurOrderID-results\"]");
    private final By selectPurQuoteChild = By.tagName("li");
    private final By selectItem =By.xpath("//*[@id=\"tblItems\"]/tbody/tr/td[1]/div[1]/input");
    private final By suppliersSearch = By.xpath("//*[@id=\"LKSupplierID\"]");
    private final By suppliersSearchBtn=By.xpath("//*[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By suppliersSearchByname=By.xpath("//*[@id=\"SearchControl_Criteria_List_2__Value\" and contains(@type,\"text\")]");

    private final By suppliersSearchResultParent = By.xpath("/html/body/div[6]/div/div[3]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]");
    private final By suppliersSearchResultChild = By.tagName("a");
    private final By chooseBtn = By.xpath("/html/body/div[6]/div/div[3]/div/div/div[2]/form/div[2]/div/table/tbody/tr[1]/td[5]/a");

    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");



    public PurQuoteRequest selectPurQuoteNumber() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectPurQuoteNumber);
                store.click();
                Thread.sleep(1500);

                waitForPresenceElement(selectPurQuoteParent);
                WebElement parent = driver.findElement(selectPurQuoteParent);
                List<WebElement>childs= parent.findElements(selectPurQuoteChild);
                childs.get(1).click();

                JavascriptExecutor js = (JavascriptExecutor)driver ;
                js.executeScript("window.scrollBy(0,100);");
                Thread.sleep(1500);

                WebElement items = waitForClickableElement(selectItem);
                items.click();

                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting PurQuoteNumber");
                navigateToPurQuoteRequestPage();
            }
        }
        throw new RuntimeException("failed selecting PurQuoteNumber after " +maxAttempt);

    }

    public PurQuoteRequest scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        return this ;
    }

    public PurQuoteRequest clickOnSupplier() throws InterruptedException{
        int maxAttempt = 3 ;
        for (int attempt =0 ; attempt<maxAttempt; attempt++) {
            try {
                WebElement suppliers = waitForClickableElement(suppliersSearch);
                suppliers.click();

                WebElement supplierSearch = waitForClickableElement(suppliersSearchBtn);
                supplierSearch.click();
                /*
                WebElement parent = waitForPresenceElement(suppliersSearchResultParent);
                List<WebElement> child = parent.findElements(suppliersSearchResultChild);
                child.get(0).click();

                 */
                WebElement supNameSearch = waitForClickableElement(suppliersSearchByname);
                supNameSearch.sendKeys("مكتبة جرير");
                WebElement choose = waitForClickableElement(chooseBtn);
                choose.click();

                return this;
            } catch (Exception e) {
                System.out.println("Retrying click on supplier search btn ");
            }
        }
        throw new RuntimeException("Failed to click on supplier search btn ");
    }

    public PurQuoteRequest clickOnSaveBtn() throws InterruptedException{
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

    public PurQuoteRequest clickOnSearchTab()throws InterruptedException{
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
    public PurQuoteRequest clickOnSearchBtn() throws InterruptedException{
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
                System.out.println("retrying searchResultIsDisplayed.....");
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


    public PurQuoteRequest clickOnEditBtn() throws InterruptedException{
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

    public PurQuoteRequest clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public PurQuoteRequest clickOnDeleteBtn() throws InterruptedException{

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

    public PurQuoteRequest scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(editBtn));
        return this ;
    }


}

