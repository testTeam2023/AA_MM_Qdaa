package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ItemForShow;
import QdaaStore.pages.mainOperations.ReturnsDepartmentRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemForShowTest extends TestBase {
    private ItemForShow itemForShow ;
    @Test
    public void setItemFrShowTest(){
        itemForShow = new ItemForShow(driver);
        itemForShow
                .navigateToItemForShowPage();
        Assert.assertTrue(itemForShow.itemForShowIsDisplayed());

    }

}
