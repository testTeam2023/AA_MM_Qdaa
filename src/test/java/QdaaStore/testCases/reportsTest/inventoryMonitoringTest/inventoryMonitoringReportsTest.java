package QdaaStore.testCases.reportsTest.inventoryMonitoringTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.reports.inventoryMonitoring.inventoryMonitoringReports;
import QdaaStore.pages.reports.procurement.ProcurementReports;
import org.testng.annotations.Test;

public class inventoryMonitoringReportsTest extends TestBase {

    private inventoryMonitoringReports inventoryMonitoringReports  ;

    @Test
    public void setInventoryMonitoringReports(){

        inventoryMonitoringReports=new inventoryMonitoringReports(driver);
        inventoryMonitoringReports.navigateToReport20Page()
                .report20IsDisplayed();
        inventoryMonitoringReports.navigateToReport21Page()
                .report21IsDisplayed();
        inventoryMonitoringReports.navigateToReport22Page()
                .report22IsDisplayed();
        inventoryMonitoringReports.navigateToReport23Page()
                .report23IsDisplayed();
        inventoryMonitoringReports.navigateToReport24Page()
                .report24IsDisplayed();
        inventoryMonitoringReports.navigateToReport30Page()
                .report30IsDisplayed();
        inventoryMonitoringReports.navigateToReport31Page()
                .report31IsDisplayed();
        inventoryMonitoringReports.navigateToReport42Page()
                .report42IsDisplayed();
        inventoryMonitoringReports.navigateToReport43Page()
                .report43IsDisplayed();
        inventoryMonitoringReports.navigateToReport65Page()
                .report65IsDisplayed();
        inventoryMonitoringReports.navigateToReport66Page()
                .report66IsDisplayed();
        inventoryMonitoringReports.navigateToReport67Page()
                .report67IsDisplayed();
        inventoryMonitoringReports.navigateToReport74Page()
                .report74IsDisplayed();




    }
}
