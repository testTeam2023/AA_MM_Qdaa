package QdaaStore.testCases.reportsTest.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.reports.assets.assetsReports;
import QdaaStore.pages.reports.procurement.ProcurementReports;
import org.testng.annotations.Test;

public class assetsReportsTest extends TestBase {

    private assetsReports assetsReports ;

    @Test
    public void setAssetsReports(){

        assetsReports=new assetsReports(driver);
        assetsReports.navigateToReport101Page()
                .report101IsDisplayed();
        assetsReports.navigateToReport102Page()
                .report102IsDisplayed();
        assetsReports.navigateToReport103Page()
                .report103IsDisplayed();
        assetsReports.navigateToReport104Page()
                .report104IsDisplayed();


    }
}
