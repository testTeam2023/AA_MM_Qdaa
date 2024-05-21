package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ReturnsDepartment {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ReturnsDepartment (WebDriver driver){
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
    public ReturnsDepartment navigateToReturnsDepartmentPage() {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReturnsDepartmentPage());
                Thread.sleep(2500);
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to return department page url ...");
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
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6/span");

    private final By selectReturnType = By.xpath("//*[@id=\"select2-ReturnTypeID-container\"]");
    private final By returnTypeSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectReturnReason = By.xpath("//*[@id=\"select2-ReturnCauseID-container\"]");
    private final By returnReasonSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");
    private final By selectReturnStore = By.xpath("//*[@id=\"select2-StoreID-container\"]");
    private final By returnStoreSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By selectStoreKeeper = By.xpath("//*[@id=\"select2-CuratorID-container\"]");
    private final By storeKeeperSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By selectEmployee = By.xpath("//*[@id=\"select2-EmployeeIDReturned-container\"]");
    private final By employeeNameSearch = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    private final By selectDepartmentManger = By.xpath("//*[@id=\"select2-DeptManagerID-container\"]");
    private final By searchDepartmentMangerField = By.xpath("//*[@class=\"select2-search select2-search--dropdown\"]//input");

    public ReturnsDepartment selectReturnType(String returnTypes ) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement returnType = waitForClickableElement(selectReturnType);
                returnType.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(returnTypeSearch);
                search.sendKeys(returnTypes, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting return Type");
                navigateToReturnsDepartmentPage();
            }
        }
        throw new RuntimeException("failed selecting return Type after " +maxAttempt);

    }

    public ReturnsDepartment selectReturnReason(String returnReasons) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement returnReason = waitForClickableElement(selectReturnReason);
                returnReason.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(returnReasonSearch);
                search.sendKeys(returnReasons, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting return Reason ");
            }
        }
        throw new RuntimeException("failed selecting return Reason after " +maxAttempt);
    }
    public ReturnsDepartment selectReturnStore(String storeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement store = waitForClickableElement(selectReturnStore);
                store.click();
                Thread.sleep(1500);

                WebElement storeSearch = waitForClickableElement(returnStoreSearch);
                storeSearch.sendKeys(storeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting select Return Store");
            }
        }
        throw new RuntimeException("failed selecting select return Store after " +maxAttempt);
    }

    public ReturnsDepartment selectStoreKeeper(String storeKeeperName) throws InterruptedException {
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
    public ReturnsDepartment selectEmployee(String employeeName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement employee = waitForClickableElement(selectEmployee);
                employee.click();
                Thread.sleep(1500);

                WebElement serach = waitForClickableElement(employeeNameSearch);
                serach.sendKeys(employeeName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting employee name");
            }
        }
        throw new RuntimeException("failed selecting employee name after " +maxAttempt);

    }
    public ReturnsDepartment selectDepartmentManger(String departmentMangerName) throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement departmentManger = waitForClickableElement(selectDepartmentManger);
                departmentManger.click();
                Thread.sleep(1500);

                WebElement search = waitForClickableElement(searchDepartmentMangerField);
                search.sendKeys(departmentMangerName, Keys.ENTER);
                return this;
            } catch (Exception e) {
                System.out.println("Retrying  selecting department manager name");
            }
        }
        throw new RuntimeException("failed selecting department manager name after " +maxAttempt);

    }

    public ReturnsDepartment scrollDownForSearch()throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,220);");
        Thread.sleep(1000);
        return this ;
    }
    public ReturnsDepartment scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550);");
        return this ;
    }
    public ReturnsDepartment scrollDownc(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150);");
        return this ;
    }

    private final By itemNumberBtn= By.xpath("//*[@id=\"FormAddOrEdit_ReturnsDepartmentDtl\"]/div[1]/div/label[4]");
    private final By itemNum = By.xpath("//*[@id=\"SearchKey\"]");
    private final By itemQty = By.xpath("//*[@id=\"ReturnsQuantity\"]");
    private final By addBtn = By.xpath("//*[@id=\"btnAddNewItem\"]");

    public ReturnsDepartment addItem(String itemNumbers ,String itemqtys) throws InterruptedException {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement itemNumBtn = waitForClickableElement(itemNumberBtn);
                itemNumBtn.click();

                WebElement itemNumber = waitForClickableElement(itemNum);
                itemNumber.sendKeys(itemNumbers, Keys.ENTER);
                Thread.sleep(2000);

                WebElement qty = waitForClickableElement(itemQty);
                qty.clear();
                qty.sendKeys(itemqtys);
                WebElement add = waitForClickableElement(addBtn);
                add.click();
                Thread.sleep(3000);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350);");
                return this;
            }
            catch (Exception e){
                System.out.println("try add item and click on btn ");
            }}
        throw new RuntimeException("failed to add item and btn check the test data");
    }

    private final By addAllEmployeeItems=By.xpath("//*[@id=\"btnAddAllItem\"]");


      public ReturnsDepartment clickOnaddAllEmployeeItemsBtn() throws InterruptedException{
        WebElement allBtn = waitForClickableElement(addAllEmployeeItems);
        allBtn.click();
        Thread.sleep(1000);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,600);");
          return this ;
    }
    private final By saveBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"حفظ\")]");
    private final By okBtn = By.xpath("//button[@id=\"btn-ok-modal\"]");
    private final By successMessage = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحفظ بنجاح\")]");
    private final By successMessageOfNotFixed = By.xpath("//div[@id=\"div-success-modal\"]//div[contains(text(),\"تم تثبيت الإلغاء\")]");
    private final By fixed = By.xpath("//input[@id=\"btnFixing\"]");
    private final By notFixed = By.xpath("//input[@id=\"btnCancelFixed\"]");

    public ReturnsDepartment clickOnSaveBtn() throws InterruptedException{
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

    public ReturnsDepartment clickOnFixedBtn() throws InterruptedException{

        WebElement fixedButton = waitForClickableElement(fixed);
        fixedButton.click();
        Thread.sleep(1500);

        WebElement okButton = waitForClickableElement(okBtn);
        okButton.click();

        return this ;
    }
    public ReturnsDepartment clickOnNotFixedBtn() {
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

    private final By  searchTab = By.xpath("//a[@id=\"AnchorfirstTab\"]");
    private final By  searchBtn = By.xpath("//input[@class=\" btn-info btn-3d btn \" and contains(@value,\"بـحـث\")]");
    private final By  searchData = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody");

    public ReturnsDepartment clickOnSearchTab()throws InterruptedException{
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
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                System.out.println("Exception occured " + e.getMessage());
                navigateToReturnsDepartmentPage();
                System.out.println("Page refreshed. Retrying click...");

            }
        }
        throw new RuntimeException("Failed to click on search tab after " + maxAttempt + " attempts");

    }
    public ReturnsDepartment clickOnSearchBtn() throws InterruptedException{
        int maxAttempt = 10;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                WebElement search= wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
               // Actions actions = new Actions(driver);
               // actions.moveToElement(search).click().build().perform();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", search);
                search.click();
                Thread.sleep(3500);
                return this;
            } catch (Exception e) {
                System.out.println("Page refreshed. Retrying click on search btn..."+ e.getMessage());
                navigateToReturnsDepartmentPage();
                clickOnSearchTab();
                scrollDownForSearch();
            }
        }
        throw new RuntimeException("Failed to click on search button after " + maxAttempt + " attempts");
    }
    public boolean searchResultIsDisplayed() throws InterruptedException{
        int maxRetry = 5;
        for (int retry = 0; retry < maxRetry; retry++){
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(searchData)).isDisplayed();
            }
            catch (Exception e){
                System.out.println("retrying display search results.....");
                driver.navigate().refresh();
                Thread.sleep(3500);
                clickOnSearchTab().clickOnSearchBtn();
            }

        }
        throw new RuntimeException("failed to display search results after " +maxRetry + " attempts");
    }

    // Edit function

    private final By  editBtnParent = By.xpath("//table[@id=\"tblDataTableClient\"]/tbody/tr[1]/td[8]");
    private final By  editBtnChild = By.tagName("a");
    private final By  editBtn = By.xpath("//*[@id=\"btnSave\" and contains(@value,\"تعديل\")]");
    private final By deleteSuccessMessage = By.xpath("//*[@id=\"div-success-modal\"]//div[contains(text(),\"تم الحذف بنجاح\")]");

    public ReturnsDepartment clickOnEditBtn() throws InterruptedException{
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
                System.out.println("Re trying to click on edit btn "+ e.getMessage());
                navigateToReturnsDepartmentPage().clickOnSearchTab().scrollDownForSearch().clickOnSearchBtn();
            }
        }
        throw new RuntimeException("Failed to click on edit btn after all attempt");

    }
    public ReturnsDepartment scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900);");
        return this ;
    }
    public ReturnsDepartment scrollAfterSearchBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,180);");
        return this;
    }

    public ReturnsDepartment clickOnEditSaveBtn() throws InterruptedException{
        WebElement edit = waitForClickableElement(editBtn);
        Actions actions =new Actions(driver);
        actions.moveToElement(edit).click().build().perform();

        Thread.sleep(1500);

        WebElement ok = waitForClickableElement(okBtn);
        Actions actions1 =new Actions(driver);
        actions.moveToElement(ok).click().build().perform();
        return this;

    }

    public ReturnsDepartment clickOnDeleteBtn() throws InterruptedException{
             int maxAttempt= 3;
             for (int attempt=0; attempt<maxAttempt; attempt++){
                 try {

                     WebElement parent = waitForVisibilityElement(editBtnParent);

                     List<WebElement> child = parent.findElements(editBtnChild);
                     child.get(1).click();
                 }
                 catch (Exception e)
                 {
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
                return this ;
            }

    public boolean getDeleteSuccessMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteSuccessMessage)).isDisplayed();
    }


















}
