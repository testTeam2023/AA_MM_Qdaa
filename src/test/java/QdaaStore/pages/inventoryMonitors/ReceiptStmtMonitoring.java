package QdaaStore.pages.inventoryMonitors;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ReceiptStmtMonitoring {
    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public ReceiptStmtMonitoring (WebDriver driver){
        this.driver=driver;
        this.wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitForVisibilityElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public ReceiptStmtMonitoring navigateToReceiptStmtMonitoringPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getReceiptStmtMonitoringPage());
                Thread.sleep(3500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to ReceiptStmtMonitoring page url ...");
            }
        }
        throw new RuntimeException("page load Times Out (Server Stopped ) or Publish Issues after " + maxAttempt + " attempts");
    }

    private final By receiptStmtMonitoring = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6") ;

    public boolean receiptStmtMonitoringIsDisplayed(){
        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(receiptStmtMonitoring).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying open the page ");
                navigateToReceiptStmtMonitoringPage();
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues");
    }

}
