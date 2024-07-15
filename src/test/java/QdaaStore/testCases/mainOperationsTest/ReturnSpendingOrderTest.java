package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ReturnSpendingOrder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReturnSpendingOrderTest extends TestBase {

    private ReturnSpendingOrder returnSpendingOrder ;


    @DataProvider
    public Object[][] data (){
        return new Object[][]{
                {"كريم محمد شاكر فتحى","إدارة_         1","1055636300","199","1","1"}
        };
    }
    @Test(dataProvider = "data", priority = 1)
    public void creatReturnSpendingOrderFlow(String storeKeeper,String departmentName,String receiverNumber,String itemNum ,String spntQty ,String RecommendationQty  )throws  InterruptedException{
        returnSpendingOrder = new ReturnSpendingOrder(driver);
        SoftAssert softAssert= new SoftAssert();
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .selectStoreName()
                .selectStoreKeeper(storeKeeper)
                .selectDepartment(departmentName)
                .selectReceiverName(receiverNumber)
                .scrollDown()
                .addItem(itemNum,spntQty,RecommendationQty)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(returnSpendingOrder.fixedBtnDisable());
// Search
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(returnSpendingOrder.searchResultIsDisplayed());
//Edit
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(returnSpendingOrder.notFixedBtnDisable());
//Delete
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }
/*
    @Test(priority = 2)
    public void returnsSpendingOrderSearch() throws InterruptedException{
        returnSpendingOrder = new ReturnSpendingOrder(driver);
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        Assert.assertTrue(returnSpendingOrder.searchResultIsDisplayed());
    }

    @Test(priority = 3 , dependsOnMethods = "creatReturnSpendingOrder")
    public void returnsSpendingOrderEdit() throws InterruptedException{
        returnSpendingOrder = new ReturnSpendingOrder(driver);
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        Assert.assertTrue(returnSpendingOrder.fixedBtnDisable());
    }

    @Test(priority = 4 , dependsOnMethods = "")
    public void returnsSpendingOrderDelete() throws InterruptedException{
        returnSpendingOrder = new ReturnSpendingOrder(driver);
        returnSpendingOrder
                .navigateToReturnSpendingOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }





*/

}
