package QdaaStore.testCases.systemSettingsTest;
import QdaaStore.basess.TestBase;
import QdaaStore.pages.systemSettings.Items;
import QdaaStore.utils.RandomArItems;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ItemsTest extends TestBase {
    Items items ;
    @Test(priority = 0)
    public void createItem() throws InterruptedException {
     items = new Items(driver);
     items
             .navigateToItemsPage()
             .chooseItemClassification()
             .enterItemName(RandomArItems.randomItemsName())
             .chooseItemType()
             .chooseUnit()
             .chooseStore()
             .clickOnSaveBtn();
    }
    @Test(priority = 1)
    public void ItemsSearch()throws InterruptedException{
     items = new Items(driver);
     items
             .navigateToItemsPage()
             .clickOnSearchTab()
             .scrollDownForSearch()
             .clickOnSearchBtn();}

    @Test(priority = 2)
    public void itemsEdit()throws InterruptedException{
        items = new Items(driver);
        items
                .navigateToItemsPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .editMaxQty()
                .clickOnEditSaveBtn();
    }
    @Test(priority = 3)
    public void ItemsDelete()throws InterruptedException{
        items = new Items(driver);
        items
                .navigateToItemsPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();



    }








}
