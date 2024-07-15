package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.procurement.PurOrder;
import QdaaStore.pages.procurement.PurQuote;
import QdaaStore.pages.procurement.PurQuoteRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurQuoteTest extends TestBase {
    private PurOrder purOrder ;
    private PurQuoteRequest purQuoteRequest ;
    private PurQuote purQuote ;

    @DataProvider
    public  Object[][] dataForPurOrder(){
        return new Object[][]{

                {"إدارة_         1","دليل الاصناف","199","1"}
        };

    }
    @Test(dataProvider = "dataForPurOrder")

    public void purQuoteFlow(String departmentName , String itemType, String itemNum,String itemQty) throws InterruptedException{
        purOrder = new PurOrder(driver);
        purQuoteRequest = new PurQuoteRequest(driver);
        purQuote = new PurQuote(driver);
        SoftAssert softAssert = new SoftAssert();
        purOrder
                .navigateToPurOrderPage()
                .selectDepartment(departmentName)
                .scrollDown()
                .addItem(itemType,itemNum,itemQty)
                .clickOnSaveBtn();

        purQuoteRequest
                .navigateToPurQuoteRequestPage()
                .selectPurQuoteNumber()
                .clickOnSupplier()
                .clickOnSaveBtn();

        purQuote
                .navigateToPurQuotePage()
                .selectPurQuoteNumber()
                .selectSupplier()
                .scrollDown()
                .editPrice()
                .clickOnSaveBtn();

        // Search
        purQuote
                .navigateToPurQuotePage()
                .clickOnSearchTab()
                .clickOnSearchBtn();
        softAssert.assertTrue(purQuote.searchResultIsDisplayed());

        //Edit
        purQuote
                .navigateToPurQuotePage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnEditSaveBtn();
        softAssert.assertTrue(purQuote.getEditSuccessMessage());

        // Delete
        purQuote
                .navigateToPurQuotePage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();







    }










}
