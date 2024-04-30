package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ReceiptStmt;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReceiptStmtTest extends TestBase {

    private ReceiptStmt receiptStmt ;
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"199","2","50","الاجهزة الالكترونية"}
        } ;

    }
    @Test(dataProvider = "data" , priority = 1)
    public void createReceiptStmtFlow(String itemNum,String qty, String price ,String storeName) throws InterruptedException
    {
        receiptStmt = new ReceiptStmt(driver);
        SoftAssert softAssert= new SoftAssert();

        receiptStmt
                .navigateToReceiptStmtPage()
                .selectSupplier()
                .selectStore(storeName)
                .scrollDown()
                .addItems(itemNum,qty,price)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(receiptStmt.fixedBtnDisable());
        // Search
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDownTo()
                .clickOnSearchBtn();
        // Edit
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDownTo()

                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(receiptStmt.notFixedBtnDisable());

        // Delete
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDownTo()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();


    }
/*
    @Test(priority = 2)
    public void receiptStmtSearch() throws InterruptedException{
        receiptStmt = new ReceiptStmt(driver);
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        Assert.assertTrue(receiptStmt.searchResultIsDisplayed());
    }

    @Test(priority = 3,dependsOnMethods = "createReceiptStmt")
    public void receiptStmtEdit() throws InterruptedException{
        receiptStmt = new ReceiptStmt(driver);
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();

    }

    @Test(priority = 4,dependsOnMethods = "receiptStmtEdit")
    public void receiptStmtDelete() throws InterruptedException{
        receiptStmt = new ReceiptStmt(driver);
        receiptStmt
                .navigateToReceiptStmtPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();

    }
*/



}
