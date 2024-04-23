package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.InventoryDepartment;
import QdaaStore.pages.inventoryMonitors.InventoryMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryDepartmentTest extends TestBase {

    private InventoryDepartment inventoryDepartment ;
    @Test
    public void setClosingFinYear(){
        inventoryDepartment = new InventoryDepartment(driver);
        inventoryDepartment
                .navigateToInventoryDepartmentPage();
        Assert.assertTrue(inventoryDepartment.inventoryDepartmentIsDisplayed());

    }
}
