package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ItemsTransfeer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ItemsTransfeerTest extends TestBase {

    private ItemsTransfeer itemsTransfeer ;

    @DataProvider
    public Object[][] data (){
        return new Object[][]{
                {"1","الرجيع","الاجهزة الالكترونية","عمرو عبدالعزيز حسن كمال","199","1"},
                {"2","الرجيع","الاجهزة الالكترونية","عمرو عبدالعزيز حسن كمال","199","1"},
                {"3","الرجيع","الرجيع","عمرو عبدالعزيز حسن كمال","199","1"},
                {"4","الرجيع","الاجهزة الالكترونية","عمرو عبدالعزيز حسن كمال","199","1"}
        };
    }
    @Test(dataProvider = "data", priority = 1)
    public void createItemsTransferFlow(String transferType,String storeFrom_name,String storeTo_name,String storeKeeperName,String itemNum ,String transQty   )throws  InterruptedException{
        itemsTransfeer = new ItemsTransfeer(driver);
        SoftAssert softAssert= new SoftAssert();
        itemsTransfeer
                .navigateToItemsTransferPage()
                .selectTransferType(transferType)
                .selectFromStore(storeFrom_name)
                .selectToStore(storeTo_name)
                .selectStoreKeeper(storeKeeperName)
                .scrollDown()
                .addItem(itemNum,transQty)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(itemsTransfeer.fixedBtnDisable());
// Search
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(itemsTransfeer.searchResultIsDisplayed());
//Edit
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(itemsTransfeer.notFixedBtnDisable());
//Delete
        itemsTransfeer
                .navigateToItemsTransferPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }
}
