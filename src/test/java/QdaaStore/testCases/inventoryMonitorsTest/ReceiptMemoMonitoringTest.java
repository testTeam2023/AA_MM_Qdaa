package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.ReceiptMemoMonitoring;
import QdaaStore.pages.inventoryMonitors.ReceiptStmtMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReceiptMemoMonitoringTest   extends TestBase {

    private ReceiptMemoMonitoring receiptMemoMonitoring ;
    @Test
    public void setClosingFinYear(){
        receiptMemoMonitoring = new ReceiptMemoMonitoring(driver);
        receiptMemoMonitoring
                .navigateToReceiptMemoMonitoringPage();
        Assert.assertTrue(receiptMemoMonitoring.receiptMemoMonitoringIsDisplayed());

    }

}
