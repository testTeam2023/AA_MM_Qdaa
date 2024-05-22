package QdaaStore.pages.mainOperations;

import QdaaStore.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CompetitionReq {

    private final WebDriver driver ;
    private final FluentWait<WebDriver> wait;

    public CompetitionReq (WebDriver driver){
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
    public CompetitionReq navigateToCompetitionReqPage() {
        int maxAttempt = 3;
        for (int attempt = 0; attempt < maxAttempt; attempt++) {
            try {
                driver.get(ConfigUtils.getInstance().getCompetitionReqPage());
                Thread.sleep(2500);
                return this;
            } catch (Exception e) {
                driver.navigate().refresh();
                System.out.println("Page refreshed. Retrying navigate to CompetitionReq page url ...");
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues after " + maxAttempt + " attempts");
    }

        private final By competitionReq = By.xpath("//*[@id=\"content\"]/div[1]/div/div/h6") ;

    public boolean competitionReqIsDisplayed(){

        int maxAttempts = 3;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                return waitForVisibilityElement(competitionReq).isDisplayed();
            } catch (Exception e) {
                System.out.println("retrying open the page ");
                navigateToCompetitionReqPage();
            }
        }
        throw new RuntimeException("page load Times Out or Publish Issues");
    }
}
