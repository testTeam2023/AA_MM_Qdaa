package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.InventoryMonitoring;
import QdaaStore.pages.inventoryMonitors.ReceiptMemoMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryMonitoringTest extends TestBase {

    private InventoryMonitoring inventoryMonitoring ;
    @Test
    public void setClosingFinYear(){
        inventoryMonitoring = new InventoryMonitoring(driver);
        inventoryMonitoring
                .navigateToInventoryMonitoringPage();
        Assert.assertTrue(inventoryMonitoring.inventoryMonitoringIsDisplayed());

    }

}
