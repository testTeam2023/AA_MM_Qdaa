package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.procurement.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ContractTest extends TestBase {
    private Contract contract ;
    SoftAssert softAssert = new SoftAssert();
    private PurOrder purOrder ;
    private PurQuoteRequest purQuoteRequest ;
    private PurQuote purQuote ;
    private PurQuoteComparison purQuoteComparison ;

    @DataProvider
    public Object[][] dataForContract(){
        return new Object[][]{
                {true,"","","","","رئيس المجلس/الإدارة العامة للخدمات المشتركة","دليل الاصناف","199","1"},
                {false,"الاجهزة الالكترونية","199","1","250","رئيس المجلس/الإدارة العامة للخدمات المشتركة","دليل الاصناف","199","1"}

        };
    }
    @Test(dataProvider = "dataForContract")
    public void createContractFlow(boolean type, String store ,String itemNumb, String itemQTYs , String prices ,String departmentName , String itemType ,String itemNum, String itemQty  ) throws InterruptedException {
        contract = new Contract(driver);
        purOrder = new PurOrder(driver);
        purQuoteRequest = new PurQuoteRequest(driver);
        purQuote = new PurQuote(driver);
        purQuoteComparison=new PurQuoteComparison(driver);

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

        purQuoteComparison
                .navigateToPurQuoteComparisonPage()
                .selectPurQuoteNumber()
                .clickOnSaveBtn();

        if (type == true) {
            contract.navigateToContractPage()
                    .selectTypeOfContract(type)
                    .selectPurQuoteNumber()
                    .selectSupplier1()
                    .enterContractSubject()
                    .scrollDown()
                    .clickOnSaveBtn();

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .clickOnSearchBtn();
            softAssert.assertTrue(contract.searchResultIsDisplayed());

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnEditSaveBtn();
            softAssert.assertTrue(contract.getEditSuccessMessage());

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnDeleteBtn();

        } else {
            contract
                    .navigateToContractPage()
                    .selectTypeOfContract(type)
                    .selectSupplier2()
                    .selectStore(store)
                    .enterContractSubject()
                    .scrollDown()
                    .addItem(itemNum, itemQTYs, prices)
                    .clickOnSaveBtn();
            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .clickOnSearchBtn();
            softAssert.assertTrue(contract.searchResultIsDisplayed());

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnEditSaveBtn();
            softAssert.assertTrue(contract.getEditSuccessMessage());

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnDeleteBtn();


        }

    }
    }
