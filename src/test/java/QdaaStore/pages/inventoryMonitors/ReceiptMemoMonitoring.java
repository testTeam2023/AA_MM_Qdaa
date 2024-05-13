package QdaaStore.pages.inventoryMonitors;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ReceiptMemoMonitoring {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ReceiptMemoMonitoring (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public ReceiptMemoMonitoring navigateToReceiptMemoMonitoringPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReceiptMemoMonitoringPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to ReceiptMemoMonitoring page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By receiptMemoMonitoring = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6/i") ;

    public boolean receiptMemoMonitoringIsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(receiptMemoMonitoring).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying open the page ");
                navigateToReceiptMemoMonitoringPage();
            }
        }
        throw new RuntimeException("failed to open the receiptMemoMonitoring page check the page manually ");
    }


}
