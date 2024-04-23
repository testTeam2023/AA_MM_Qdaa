package QdaaStore.factoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
public class Factory {
    public WebDriver initialization(){
        String browser = System.getProperty("browser","chrome");
        WebDriver driver ;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver= new EdgeDriver();
            }
            default -> throw new RuntimeException("the browser not supported");
        }
        driver.manage().window().maximize();
        return driver;

    }

}
