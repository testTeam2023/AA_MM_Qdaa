package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.Inventory;
import QdaaStore.pages.mainOperations.ItemForShow;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends TestBase {

    private Inventory inventory ;
    @Test
    public void setInventoryTest(){
        inventory = new Inventory(driver);
        inventory
                .navigateToInventoryPage();
        Assert.assertTrue(inventory.inventoryIsDisplayed());

    }
}
