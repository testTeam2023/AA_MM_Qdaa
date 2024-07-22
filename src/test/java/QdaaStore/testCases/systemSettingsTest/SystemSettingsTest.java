package QdaaStore.testCases.systemSettingsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.systemSettings.SystemSettings;
import QdaaStore.utils.Randoms;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SystemSettingsTest extends TestBase {
   private SystemSettings systemSettings ;

   @Test

    public void systemSettingsFlow() throws InterruptedException{

       SoftAssert softAssert = new SoftAssert();
       systemSettings=new SystemSettings(driver);
       systemSettings.mainPageLoad().clickOnSystemSettingsButton()
               .navigateToSettingPage()
               .clickOnSaveButton()
               .clickOnSuccessMessageButton();

       systemSettings.mainPageLoad().clickOnSystemSettingsButton()
               .navigateToCitiesPage()
               .enterCityName(Randoms.randomArData())
               .clickOnSaveButton()
               .clickOnSuccessMessageButton();

       systemSettings.mainPageLoad()
               .clickOnSystemSettingsButton()
               . navigateToUnitPage()
               .enterUnitName(Randoms.randomArData())
               .clickOnSaveButton()
               .clickOnSuccessMessageButton();

       systemSettings.mainPageLoad().clickOnSystemSettingsButton()
               .navigateToBanksPage()
               .enterBankDetails(Randoms.randomArData(), Randoms.randomArData())
               .clickOnSaveButton()
               .clickOnSuccessMessageButton();

       systemSettings.mainPageLoad().clickOnSystemSettingsButton().navigateToSuppliersWorkAreaPage()
               .enterSuppWorkAreaDetails(Randoms.randomArData())
               .clickOnSaveButton().clickOnSuccessMessageButton();


        systemSettings.mainPageLoad()
               .clickOnSystemSettingsButton()
               .navigateToSuppliersPage()
               .clickOnSaveButton();

      boolean actuall = systemSettings.mainPageLoad().clickOnSystemSettingsButton().navigateToStoresPage()
               .clickOnSaveButton()
               .storeErrorMessageIsDisplayed();
       softAssert.assertTrue(actuall);

       systemSettings.mainPageLoad()
               .navigateToStoresCuratorPage()
               .clickOnSaveButton();
       String actual1 ="أمناء المستودعات - اعدادات النظام";
       softAssert.assertEquals(actual1,systemSettings.storeEmployeeErrorMessageText());

       boolean actual2 = systemSettings.mainPageLoad().clickOnSystemSettingsButton().navigateToClassificationsPage()
               .clickOnSaveButton()
               .classificationErrorMessageIsDisplayed();
       softAssert.assertTrue(actual2);

       systemSettings.mainPageLoad()
               .clickOnSystemSettingsButton()
               .navigateToEncodingGroupPage()
               .clickOnSaveButton() ;









   }
}
