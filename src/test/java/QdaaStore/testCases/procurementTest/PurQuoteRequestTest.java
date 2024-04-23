package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.procurement.PurOrder;
import QdaaStore.pages.procurement.PurQuoteRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurQuoteRequestTest extends TestBase {

    private  PurQuoteRequest purQuoteRequest ;
    private PurOrder purOrder ;
    @DataProvider
    public  Object[][] data(){
        return new Object[][]{

                {"رئيس المجلس/الإدارة العامة للخدمات المشتركة","دليل الاصناف","199","1"}
        };

    }
    @Test(dataProvider = "data")
    public void purQuoteRequestFlow(String departmentName , String itemType, String itemNum,String itemQty) throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        purOrder = new PurOrder(driver);
       purOrder
                .navigateToPurOrderPage()
                .selectDepartment(departmentName)
               .scrollDown()
                .addItem(itemType,itemNum,itemQty)
               .clickOnSaveBtn();

        purQuoteRequest = new PurQuoteRequest(driver);

        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .selectPurQuoteNumber()
                .clickOnSupplier()
                .clickOnSaveBtn();

        // Search
        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(purQuoteRequest.searchResultIsDisplayed());

        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnEditSaveBtn();
        softAssert.assertTrue(purQuoteRequest.getEditSuccessMessage());

        // Delete
        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();




    }

}
