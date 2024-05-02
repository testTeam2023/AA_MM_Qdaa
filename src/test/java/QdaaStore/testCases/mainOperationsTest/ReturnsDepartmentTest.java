package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ReturnsDepartment;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReturnsDepartmentTest extends TestBase {

    private ReturnsDepartment returnsDepartment ;
    @DataProvider
    public Object[][]data(){
        return new Object[][]{
                {"رجيع عهدة مستعملة","إنتهاء الغرض","الرجيع", "سلمان محمد مشارى وائل","سلطان بن محمد سالم بدر","سلطان بن محمد سالم بدر","199","1"}
        };
    }

    @Test(dataProvider = "data" , priority = 1)
    public void createReturnsDepartmentFlow(String returnType, String returnReason , String ReturnStore , String storeKeeper , String employeeName , String DepartmentMangerName , String itemNum, String qty) throws InterruptedException{
        returnsDepartment = new ReturnsDepartment(driver) ;
        SoftAssert softAssert= new SoftAssert();
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .selectReturnType(returnType)
                .selectReturnReason(returnReason)
                .selectReturnStore(ReturnStore)
                .selectStoreKeeper(storeKeeper)
                .selectEmployee(employeeName)
                .selectDepartmentManger(DepartmentMangerName)
                .scrollDown()
                .addItem(itemNum,qty)
                .clickOnSaveBtn()
                .clickOnFixedBtn();
        softAssert.assertTrue(returnsDepartment.fixedBtnDisable());
        // Search
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .scrollDownForSearch()
                .clickOnSearchBtn();
        // Edit
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        softAssert.assertTrue(returnsDepartment.notFixedBtnDisable());
        // Delete
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .scrollDownc()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();
    }
/*
    @Test(priority = 2)
    public void returnsDepartmentSearch() throws InterruptedException{
        returnsDepartment = new ReturnsDepartment(driver);
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn();
        Assert.assertTrue(returnsDepartment.searchResultIsDisplayed());
    }

    @Test(priority = 3 , dependsOnMethods ="createReturnsDepartment" )
    public void returnsDepartmentEdit() throws InterruptedException{
        returnsDepartment = new ReturnsDepartment(driver);

        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnEditBtn()
                .scrollToTheEnd()
                .clickOnNotFixedBtn();
        Assert.assertTrue(returnsDepartment.fixedBtnDisable());
    }

    @Test(priority = 4 , dependsOnMethods = "returnsDepartmentEdit")
    public void spendingOrderDelete() throws InterruptedException{
        returnsDepartment = new ReturnsDepartment(driver);
        returnsDepartment
                .navigateToReturnsDepartmentPage()
                .clickOnSearchTab()
                .scrollDown()
                .clickOnSearchBtn()
                .clickOnDeleteBtn();

    }

 */



}


