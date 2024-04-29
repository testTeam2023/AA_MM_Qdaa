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

    @DataProvider
    public Object[][] dataForContracts(){
        return new Object[][]{
                {true,"","","",""},
                {false,"الاجهزة الالكترونية","199","1","250"}

        };
    }
    @Test(dataProvider = "dataForContract" , priority = 1)
    public void createContractFlow(boolean type, String store ,String itemNumb, String itemQTYs , String prices ,String departmentName , String itemType ,String itemNum, String itemQty  ) throws InterruptedException {
        contract = new Contract(driver);
        purOrder = new PurOrder(driver);
        purQuoteRequest = new PurQuoteRequest(driver);
        purQuote = new PurQuote(driver);
        purQuoteComparison = new PurQuoteComparison(driver);

        purOrder
                .navigateToPurOrderPage()
                .selectDepartment(departmentName)
                .scrollDown()
                .addItem(itemType, itemNum, itemQty)
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
    }
        @Test (dataProvider = "dataForContracts" , priority = 2)
    public void contractFlow(Boolean type , String store ,String itemNum, String itemQTYs, String prices ) throws InterruptedException{
        contract = new Contract(driver);
        if (type == true) {
            contract.navigateToContractPage()
                    .selectTypeOfContract(type)
                    .selectPurQuoteNumber()
                    .selectSupplier1()
                    .enterContractSubject()
                    .scrollDownAfterContractSubject()
                    .clickOnSaveBtn();

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .clickOnSearchBtn();

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnEditSaveBtn();


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
                    .scrollDownForAddItem()
                    .addItem(itemNum, itemQTYs, prices)
                    .clickOnSaveBtn();
            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .clickOnSearchBtn();

            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnEditBtn()
                    .scrollToTheEnd()
                    .clickOnEditSaveBtn();


            contract
                    .navigateToContractPage()
                    .clickOnSearchTab()
                    .scrollDown()
                    .clickOnSearchBtn()
                    .clickOnDeleteBtn();


        }

    }
    }
