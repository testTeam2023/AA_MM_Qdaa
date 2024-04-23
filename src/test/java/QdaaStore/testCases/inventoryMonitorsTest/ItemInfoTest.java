package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.ItemInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemInfoTest extends TestBase {

    private ItemInfo itemInfo;
    @Test
    public void itemInfoTest() throws InterruptedException{

        itemInfo = new ItemInfo(driver);
        itemInfo
                .navigateToItemInfoPage()
                .addNumberAndDisplayResults("199");
        Assert.assertTrue(itemInfo.resultsIsDisplayed());

    }

}
