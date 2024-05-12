package QdaaStore.testCases.reportsTest.mainOperationsReportTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.reports.assets.assetsReports;
import QdaaStore.pages.reports.mainOperations.MainOperationsReports;
import org.testng.annotations.Test;

public class MainOperationReportTest extends TestBase {

    private MainOperationsReports mainOperationsReports;

    @Test
    public void setMainOperationsReports(){

        mainOperationsReports=new MainOperationsReports(driver);
        mainOperationsReports.navigateToReport1Page()
                .report1IsDisplayed();
        mainOperationsReports.navigateToReport2Page()
                .report2IsDisplayed();
        mainOperationsReports.navigateToReport3Page()
                .report3IsDisplayed();
        mainOperationsReports.navigateToReport4Page()
                .report4IsDisplayed();
        mainOperationsReports.navigateToReport5Page()
                .report5IsDisplayed();
        mainOperationsReports.navigateToReport6Page()
                .report6IsDisplayed();
        mainOperationsReports.navigateToReport7Page()
                .report7IsDisplayed();
        mainOperationsReports.navigateToReport8Page()
                .report8IsDisplayed();
        mainOperationsReports.navigateToReport9Page()
                .report9IsDisplayed();
        mainOperationsReports.navigateToReport10Page()
                .report10IsDisplayed();
        mainOperationsReports.navigateToReport11Page()
                .report11IsDisplayed();
        mainOperationsReports.navigateToReport12Page()
                .report12IsDisplayed();
        mainOperationsReports.navigateToReport13Page()
                .report13IsDisplayed();
        mainOperationsReports.navigateToReport14Page()
                .report14IsDisplayed();
        mainOperationsReports.navigateToReport15Page()
                .report15IsDisplayed();
        mainOperationsReports.navigateToReport16Page()
                .report16IsDisplayed();
        mainOperationsReports.navigateToReport17Page()
                .report17IsDisplayed();
        mainOperationsReports.navigateToReport18Page()
                .report18IsDisplayed();
        mainOperationsReports.navigateToReport19Page()
                .report19IsDisplayed();
        mainOperationsReports.navigateToReport51Page()
                .report51IsDisplayed();
        mainOperationsReports.navigateToReport39Page()
                .report39IsDisplayed();
        mainOperationsReports.navigateToReport47Page()
                .report47IsDisplayed();
        mainOperationsReports.navigateToReport49Page()
                .report49IsDisplayed();
        mainOperationsReports.navigateToReport50Page()
                .report50IsDisplayed();



    }

}
