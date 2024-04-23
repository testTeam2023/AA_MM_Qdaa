package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.ReceiptStmtMonitoring;
import QdaaStore.pages.mainOperations.ClosingFinYear;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReceiptStmtMonitoringTest extends TestBase {

    private ReceiptStmtMonitoring receiptStmtMonitoring ;
    @Test
    public void setClosingFinYear(){
        receiptStmtMonitoring = new ReceiptStmtMonitoring(driver);
        receiptStmtMonitoring
                .navigateToReceiptStmtMonitoringPage();
        Assert.assertTrue(receiptStmtMonitoring.receiptStmtMonitoringIsDisplayed());

    }

}
