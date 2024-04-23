package QdaaStore.testCases.reportsTest.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.reports.procurement.ProcurementReports;
import org.testng.annotations.Test;

public class ProcurementReportsTest extends TestBase {
    private ProcurementReports procurementReports ;

    @Test
    public void setProcurementReports(){

        procurementReports=new ProcurementReports(driver);
        procurementReports.navigateToReport25Page()
                .report25IsDisplayed();
        procurementReports.navigateToReport26Page()
                .report26IsDisplayed();
        procurementReports.navigateToReport27Page()
                .report27IsDisplayed();
        procurementReports.navigateToReport28Page()
                .report28IsDisplayed();
        procurementReports.navigateToReport29Page()
                .report29IsDisplayed();


    }
}
