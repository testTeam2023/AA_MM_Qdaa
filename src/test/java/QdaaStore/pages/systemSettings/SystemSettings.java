package QdaaStore.pages.systemSettings;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SystemSettings {

    private final WebDriver driver ;
    private final FluentWait<WebDriver>wait;

    public SystemSettings(WebDriver driver){
        this.driver = driver ;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    private WebElement waitForVisibilityElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    private By systemSettingButton  = By.xpath("/html/body/nav[1]/div/ul/li[2]/a");
    private By saveButton  = By.xpath("//*[@id=\"btnSave\"]");
    private By messageSuccessButton  = By.cssSelector("#btn-ok-modal");
    private By messageSuccessIsDisplayed  = By.xpath("/html/body/div[9]/div/div");
    private By citeyName=By.xpath("//*[@id=\"City_Name\"]");
    private By unitName=By.xpath("//*[@id=\"unit_name\"]");
    private By bankName= By.xpath("//*[@id=\"BanksName\"]");
    private By bankCode= By.xpath("//*[@id=\"BanksCode\"]");
    private By classifcationName = By.xpath("//*[@id=\"CategoryName\"]");
    private By suppWorkAreaName = By.xpath("//*[@id=\"SuppClassName\"]");
    private By suppName = By.xpath("//*[@id=\"Supp_Name\"]");
    private By aadNewClassificationButton = By.xpath("//*[@id=\"btnAddNewClassification\"]");
    private By departmentName= By.xpath("//*[@id=\"DepartmentName\"]");
    private By department= By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/form/div[1]/div[2]/div/span[1]/span[1]/span/span[1]");
    private By departmentParent= By.xpath("//*[@id=\"select2-DepartmentparentId-results\"]");
    private By departmentChild= By.tagName("li");
    private By employeeDepartmentWanted= By.xpath("//*[@id=\"EmployeeDepartmentId-error\"]");
    private By storeNameWanted= By.xpath("//*[@id=\"store_name-error\"]");
    private By employeeNameWanted= By.xpath("//*[@id=\"content\"]/div[1]/div/div");
    private By classificationNameWanted= By.xpath("//*[@id=\"class_name-error\"]");
    private By financialYearNameWanted= By.xpath("//*[@id=\"FinanceYearName\"]");
    private By mainOperationsButton  = By.xpath("/html/body/nav[1]/div/ul/li[3]/a");
    private By reportsButton  = By.xpath("/html/body/nav[1]/div/ul/li[4]/a");
    private By parentMenu = By.xpath("/html/body/nav[1]/div/ul/li[2]/ul");
    private By childMenu = By.tagName("a");
    private By settingAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By citesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By unitAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By banksAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By lKCategoryAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By supplierWorkAreaAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By supplierAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By managementsAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By employeesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By storesAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By storesCuratorAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By classificationAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By itemsAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By financeYearAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By itemsReceivedRecordAssertion = By.xpath("//*[@id=\"secondTab\"]");
    private By modalSuccess = By.cssSelector("#div-success-modal > div > div");
    private By suppWantedError = By.xpath("//*[@id=\"Supp_Email-error\"]");


    public SystemSettings mainPageLoad()throws InterruptedException{
        int maxAttempt = 3;
        int attempt = 0;
        while (attempt < maxAttempt) {
            try {
                driver.get(ConfigUtils.getInstance().getUrl());
                driver.navigate().refresh();
                Thread.sleep(3000);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                if(isElementDisplay(pageAssert)) {
                    return this;
                }
                else {
                    throw new RuntimeException("The specified element is not displayed");
                }
            }
            catch (Exception e) {
                attempt++;
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
    private final By pageAssert = By.xpath("//*[@id=\"content\"]/div/div/div[1]/span");
    public SystemSettings clickOnSystemSettingsButton() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(systemSettingButton)).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public SystemSettings navigateToSettingPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement> child = parent.findElements(childMenu);
        child.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }

    public boolean settingPageIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(settingAssertion)).isDisplayed();
    }
    public SystemSettings navigateToCitiesPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(1).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }

    public boolean citiesPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(citesAssertion)).isDisplayed();
    }
    public SystemSettings navigateToUnitPage() throws InterruptedException{

        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(2).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return this;
    }

    public boolean unitPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(unitAssertion)).isDisplayed();
    }
    public SystemSettings navigateToBanksPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(3).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return this ;
    }

    public boolean banksPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(banksAssertion)).isDisplayed();
    }

    public boolean lkCategoryPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lKCategoryAssertion)).isDisplayed();
    }
    public SystemSettings navigateToSuppliersWorkAreaPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(4).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this;
    }

    public boolean supplierWorkAreaPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supplierWorkAreaAssertion)).isDisplayed();
    }
    public SystemSettings navigateToSuppliersPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(5).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450);");
        return this ;
    }

    public boolean suppliersPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(supplierAssertion)).isDisplayed();
    }

    public SystemSettings navigateToStoresPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(6).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }

    public boolean storesPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storesAssertion)).isDisplayed();
    }
    public SystemSettings navigateToStoresCuratorPage() throws InterruptedException{
        driver.get(ConfigUtils.getInstance().getStoresCuratorPage());
        return this ;
    }

    public boolean storesCuratorPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storesCuratorAssertion)).isDisplayed();
    }
    public SystemSettings navigateToClassificationsPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(8).click();
        Thread.sleep(800);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }

    public SystemSettings scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);");
        return this ;
    }

    public boolean suppWantedErrorISDisplayed(){
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(suppWantedError)).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying assert to suppWantedErrorISDisplayed ");
            }
        }
            throw new RuntimeException("failed to assert to suppWantedErrorISDisplayed ");
    }


    public boolean classificationsPageIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(classificationAssertion)).isDisplayed();
    }
    public SystemSettings navigateToEncodingGroupPage() throws InterruptedException{
        WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(parentMenu));
        List<WebElement>child = parent.findElements(childMenu);
        child.get(10).click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }

    public SystemSettings clickOnSaveButton () throws InterruptedException {
        int maxAttempt = 5;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(saveButton)).click().build().perform();
                // wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
                Thread.sleep(5000);
                return this;
            }
            catch (Exception e){
                System.out.println("Retrying click on save btn ");
            }
        }
        throw new RuntimeException(" failed to click on save btn after "+maxAttempt+ " attempt");
    }

    public SystemSettings clickOutsideTheModal () {
        Actions actions = new Actions(driver);
        try {
            actions.moveByOffset(-80, -80).click().build().perform();
        }
        catch (Exception e){
            actions.moveByOffset(80, 80).click().build().perform();
        }
        return this ;
    }
    public SystemSettings clickOnSuccessMessageButton() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalSuccess));
            wait.until(ExpectedConditions.presenceOfElementLocated(modalSuccess));
            if (driver.findElement(modalSuccess).isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessButton));
                Actions actions = new Actions(driver);
                actions.scrollToElement(driver.findElement(messageSuccessButton)).perform();
                actions.moveToElement(driver.findElement(messageSuccessButton)).click().build().perform();
            }
        }catch (Exception e) {
            boolean isTextDisplayed = driver.getPageSource().contains("تعديل");
            if (isTextDisplayed){
                System.out.println("Expected text is displayed on the page.");
            }
            else {
                System.out.println("Expected text is not displayed on the page");
            }
        }
        return this;
    }

    public boolean successMessageIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccessIsDisplayed)).isDisplayed();

    }
    public SystemSettings enterCityName(String cityName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(citeyName)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public SystemSettings enterUnitName(String unitsName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(unitName)).sendKeys(unitsName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;

    }
    public SystemSettings  enterBankDetails(String banksName , String BanksCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankName)).sendKeys(banksName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankCode)).sendKeys(BanksCode);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public SystemSettings enterClassificationDetails(String classificationsName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(classifcationName)).sendKeys(classificationsName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public SystemSettings enterSuppWorkAreaDetails(String suppsWorkAreaName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(suppWorkAreaName)).sendKeys(suppsWorkAreaName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return this ;
    }
    public SystemSettings enterSuppDetails(String suppsName ) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(suppName)).sendKeys(suppsName);
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(aadNewClassificationButton));
        wait.until(ExpectedConditions.elementToBeClickable(aadNewClassificationButton)).click();
        Thread.sleep(1500);
        return this ;
    }

    public SystemSettings enterDepartmentDetails(String departmntName){
        int attempt =0;
        int maxAttempt = 3 ;
        while (attempt<maxAttempt) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(departmentName)).sendKeys(departmntName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(department)).click();
                WebElement parent = wait.until(ExpectedConditions.presenceOfElementLocated(departmentParent));
                List<WebElement> child = parent.findElements(departmentChild);
                child.get(1).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                return this;
            } catch (Exception e) {
                System.out.println("StaleElementReferenceException occurred. Retrying...");
            }
        }
        throw new RuntimeException("failed to enter department Details");
    }

    public boolean employeeErrorMessageIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDepartmentWanted))
                .isDisplayed();
    }
    public boolean storeErrorMessageIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(storeNameWanted))
                .isDisplayed();
    }

    public String storeEmployeeErrorMessageText(){
        int MaxAttempt = 3 ;
        for (int attempt =0; attempt<MaxAttempt; attempt++) {
            try {

                String getText= wait.until(ExpectedConditions.presenceOfElementLocated(employeeNameWanted))
                        .getText();
                System.out.println(getText);
                return getText ;
            } catch (TimeoutException e) {
                System.out.println("retrying");
            }
        }
        throw new RuntimeException("fail to assert");
    }

    public boolean classificationErrorMessageIsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(classificationNameWanted))
                .isDisplayed();
    }
    public boolean financialYearErrorMessageIsDisplayed(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(financialYearNameWanted))
                .isDisplayed();
    }





}
