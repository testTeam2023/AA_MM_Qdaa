package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.InventoryDepartment;
import QdaaStore.pages.inventoryMonitors.SpendingOrderMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpendingOrderMonitoringTest extends TestBase {

    private SpendingOrderMonitoring spendingOrderMonitoring ;
    @Test
    public void setClosingFinYear(){
        spendingOrderMonitoring = new SpendingOrderMonitoring(driver);
        spendingOrderMonitoring
                .navigateToSpendingOrderMonitoringPage();
        Assert.assertTrue(spendingOrderMonitoring.spendingOrderMonitoringIsDisplayed());

    }


}
