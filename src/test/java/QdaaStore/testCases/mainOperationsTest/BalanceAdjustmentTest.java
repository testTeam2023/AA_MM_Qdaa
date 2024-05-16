package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.BalanceAdjustment;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BalanceAdjustmentTest extends TestBase {

    private BalanceAdjustment balanceAdjustment ;
    @DataProvider
    public Object[][] data (){
        return new Object[][]{
                {"الاجهزة الالكترونية","199","1","1" },
                {"الاجهزة الالكترونية","199","1","2" }

        };


    }

    @Test(dataProvider = "data")
    public void createBalanceAdjustmentFlow(String storeName ,String itemNumbers ,String adjustmntQty, String adjstmntType) throws InterruptedException{

        balanceAdjustment = new BalanceAdjustment(driver);
        SoftAssert softAssert = new SoftAssert();
        balanceAdjustment
                .navigateToBalanceAdjustmentrPage()
                .selectSoreName(storeName)
                .scrollDownForAddItem()
                .enterItemNum(itemNumbers)
                .enterAdjustmentQty(adjustmntQty)
                .enterAdjustmentType(adjstmntType)
                .clickOnAddBtn()
                .scrollDownForsaveBtn()
                .thread()
                .clickOnSaveBtn()
                .clickOnFixedBtn() ;
        softAssert.assertTrue(balanceAdjustment.fixedBtnDisable());
        //Assert.assertEquals(balanceAdjustment.getTotal(), balanceAdjustment.getActualBalance());

// Search
        balanceAdjustment
                .navigateToBalanceAdjustmentrPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        softAssert.assertTrue(balanceAdjustment.searchResultIsDisplayed());
//Edit
        balanceAdjustment
                .navigateToBalanceAdjustmentrPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(balanceAdjustment.notFixedBtnDisable());
//Delete
        balanceAdjustment
                .navigateToBalanceAdjustmentrPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }
}

