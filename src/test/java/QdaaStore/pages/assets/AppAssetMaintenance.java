package QdaaStore.pages.assets;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class AppAssetMaintenance {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public AppAssetMaintenance (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public AppAssetMaintenance navigateToAppAssetMaintenancePage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getAppAssetMaintenancePage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to AppAssetMaintenance page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By appAssetMaintenance = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h1/i") ;

    public boolean appAssetMaintenanceIsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(appAssetMaintenance).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying open the page ");
                navigateToAppAssetMaintenancePage();
            }
        }
        throw new RuntimeException("failed to open the appAssetMaintenance page check the page manually ");
    }
}
