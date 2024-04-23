package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.Examination;
import QdaaStore.pages.mainOperations.ReceiptNotify;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExaminationTest extends TestBase {

    private Examination examination ;
    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"الاجهزة الالكترونية","199","2","50"}
        } ;

    }
    @Test( dataProvider ="data" ,priority = 0)
    public void createExaminationFlow(String storeName,String itemNo , String qty , String price) throws InterruptedException
    {

        ReceiptNotify receiptNotify = new ReceiptNotify(driver);
        receiptNotify=new ReceiptNotify(driver);
        SoftAssert softAssert =new SoftAssert();
        receiptNotify
                .navigateToReceiptNotifyPage()
                .addStoreName(storeName)
                .addSupplierName()
                .addReceiverName()
                .addItems(itemNo,qty,price)
                .clickOnSaveBtn();

        examination = new Examination(driver);
        examination
                .navigateToExaminationPage()
                .clickOnReceiptNotify()
                .clickOnTechnicalMember()
                .scrollDown()
                .clickOnSaveBtn();
        softAssert.assertTrue(examination.getSuccessMessage());

        // Search
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();
        softAssert.assertTrue(examination.searchResultIsDisplayed());
        // Edit
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollDown()
                .clickOnEditSaveBtn();
        softAssert.assertTrue(examination.getSuccessMessage());
        // Delete
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
        softAssert.assertTrue(examination.getDeleteSuccessMessage());
    }
/*
    @Test(priority = 1)
    public void examinationSearch()throws InterruptedException
    {
        examination = new Examination(driver);
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn();
        Assert.assertTrue(examination.searchResultIsDisplayed());

    }
    @Test(priority = 2 )
    public void examinationEdit()throws InterruptedException {
        examination = new Examination(driver);
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollDown()
                .clickOnEditSaveBtn();
        Assert.assertTrue(examination.getSuccessMessage());

    }
    @Test(priority = 3)
    public void examinationDelete()throws InterruptedException {
        examination = new Examination(driver);
        examination
                .navigateToExaminationPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
        Assert.assertTrue(examination.getDeleteSuccessMessage());
    }

*/
    }
