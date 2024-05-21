package QdaaStore.pages.inventoryMonitors;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Transform {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public Transform (WebDriver driver){
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
    public Transform navigateToTransformPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getTransformPage());
                Thread.sleep(3500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                        throw new RuntimeException("The specified element is not displayed");
                    }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to Transform page url ..." + e.getMessage());

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

    private final By departmentFrom = By.xpath("//*[@id=\"select2-DepartmentIDFrom-container\"]");
    private final By departmentFromSearchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By departmentTo= By.xpath("//*[@id=\"select2-DepartmentIDTo-container\"]");
    private final By departmentToSearchField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By employeeFrom = By.xpath("//*[@id=\"CuratorIDFrom\"]");
    private final By employeeTo= By.xpath("//*[@id=\"CuratorIDTo\"]");
    private final By selectItemBtn= By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/form/table/tbody/tr[1]/td[8]/input");
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");


    public Transform selectDepartmentFrom(String departmentFromName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement departmntFrom = waitForClickableElement(departmentFrom);
                departmntFrom.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(departmentFromSearchField);
                search.sendKeys(departmentFromName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting department From");
                navigateToTransformPage();
            }
        }
        throw new RuntimeException("failed selecting department From after " +maxAttempt + "Attempts");

    }
    public Transform selectDepartmentTom(String departmentToName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement departmntFrom = waitForClickableElement(departmentTo);
                departmntFrom.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(departmentToSearchField);
                search.sendKeys(departmentToName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting department To");
            }
        }
        throw new RuntimeException("failed selecting department To after " +maxAttempt + "Attempts");

    }

    public Transform selectEmployeeTo(String employee_To) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement empTo = waitForClickableElement(employeeTo);
                empTo.sendKeys(employee_To, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting employee_To");
            }
        }
        throw new RuntimeException("failed selecting employee_To after " +maxAttempt + "Attempts");

    }
    public Transform selectEmployeeFrom(String employee_From) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement empFrom = waitForClickableElement(employeeFrom);
                empFrom.sendKeys(employee_From, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting employee_From");
            }
        }
        throw new RuntimeException("failed selecting employee_From after " +maxAttempt + "Attempts");

    }
    public Transform selectItems() throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement item = waitForClickableElement(selectItemBtn);
                item.click();
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting itemsBtn");
            }
        }
        throw new RuntimeException("failed selecting itemsBtn after " +maxAttempt + "Attempts");

    }

    public Transform scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250);");
        return this ;
    }
    public Transform scrollToSaveBtn(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(waitForVisibilityElement(saveBtn)) ;
        return this ;
    }
    public Transform clickOnSaveBtn() throws InterruptedException{
        WebElement saveButton = waitForClickableElement(saveBtn);
        saveButton.click();
        Thread.sleep(1500);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getSuccessMessage());
        Thread.sleep(1500);


        return this;
    }

    public boolean getSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed();
    }

    public Transform clickOnFixedBtn() {

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        return this ;
    }
    public Transform clickOnNotFixedBtn() {
        try {

            WebElement notFixedButton = waitForClickableElement(notFixed);
            Actions actions = new Actions(driver);
            actions.moveToElement(notFixedButton).click().build().perform();
            Thread.sleep(1500);

            WebElement okButton = waitForClickableElement(okBtn);
            Actions actions1 = new Actions(driver);
            actions.moveToElement(okButton).click().build().perform();

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
    private final By  searchBtn = By.xpath("//input[@class=\" btn btn-info btn-3d \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public Transform clickOnSearchTab()throws InterruptedException{
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
    public Transform clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                // Attempt to click on the search button
                WebElement search =wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
                Actions actions = new Actions(driver);
                actions.moveToElement(search).click().build().perform();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 150);");
                Thread.sleep(2000);
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

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[7]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public Transform clickOnEditBtn() throws InterruptedException{
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
    public Transform scrollToTheEnd(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(notFixed));
        return this ;
    }

    public Transform clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public Transform clickOnDeleteBtn() {

        WebElement parent = waitForVisibilityElement(editBtnParent);

        List<WebElement> child = parent.findElements(editBtnChild);
        child.get(1).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement ok = waitForClickableElement(okBtn);
            ok.click();

            SoftAssert softAssert =new SoftAssert();
            softAssert.assertTrue(getDeleteSuccessMessage());

        } catch (Exception e) {
            System.out.println("لا يمكن الحذف أو التعديل بعد التثبيت");
        }
        return this ;
    }
    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();


    }
















}
