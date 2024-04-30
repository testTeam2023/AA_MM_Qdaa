
package QdaaStore.testCases.mainOperationsTest;
import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ReceiptMemo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReceiptMemoTest extends TestBase {

        private ReceiptMemo receiptMemo ;
        @DataProvider
        public Object[][] data(){
            return new Object[][]{
                    {"199","2","50","الاجهزة الالكترونية"}
            } ;

        }
        @Test(dataProvider = "data" , priority = 1)
        public void createReceiptMemo(String itemNum,String qty, String price ,String storeName) throws InterruptedException
        {
            receiptMemo = new ReceiptMemo(driver);
            SoftAssert softAssert = new SoftAssert();

            receiptMemo
                    .navigateToReceiptMemoPage()
                    .selectSupplier()
                    .selectStore(storeName)
                    .selectEmployeeName()
                    .scrollDown()
                    .addItems(itemNum,qty,price)
                    .clickOnSaveBtn()
                    .clickOnFixedBtn();
            softAssert.assertTrue(receiptMemo.fixedBtnDisable());

            // Search
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn();
            // Edit
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnNotFixedBtn();
            softAssert.assertTrue(receiptMemo.notFixedBtnDisable());
            // Delete
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnDeleteBtn();

        }
/*
        @Test(priority = 2)
        public void receiptMemoSearch() throws InterruptedException{
            receiptMemo = new ReceiptMemo(driver);
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn();
            Assert.assertTrue(receiptMemo.searchResultIsDisplayed());
        }

        @Test(priority = 3,dependsOnMethods = "createReceiptMemo")
        public void receiptMemoEdit() throws InterruptedException{
            receiptMemo = new ReceiptMemo(driver);
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnNotFixedBtn();

        }

        @Test(priority = 4,dependsOnMethods = "receiptMemoEdit")
        public void receiptMemoDelete() throws InterruptedException{
            receiptMemo = new ReceiptMemo(driver);
            receiptMemo
                    .navigateToReceiptMemoPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnDeleteBtn();

        }

 */

    }

