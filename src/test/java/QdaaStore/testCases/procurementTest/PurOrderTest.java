package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.procurement.PurOrder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurOrderTest extends TestBase {

    private PurOrder purOrder ;

    @DataProvider
    public  Object[][] data(){
        return new Object[][]{

                {"إدارة_         1","دليل الاصناف","199","1"},
                {"إدارة_         1","صنف جديد","199","1"}
        };

    }
    @Test(dataProvider = "data")
    public void createPurOrderFlow(String departmentName , String itemType, String itemNum,String itemQty) throws InterruptedException{
        purOrder = new PurOrder(driver);
        SoftAssert softAssert = new SoftAssert();

        purOrder
                .navigateToPurOrderPage()
                .selectDepartment(departmentName)
                .scrollDown()
                .addItem(itemType,itemNum,itemQty)
                .clickOnSaveBtn();
        // Search
        purOrder
                .navigateToPurOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(purOrder.searchResultIsDisplayed());

        purOrder
                .navigateToPurOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnEditSaveBtn();
        softAssert.assertTrue(purOrder.getEditSuccessMessage());

        // Delete
        purOrder
                .navigateToPurOrderPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }


}
