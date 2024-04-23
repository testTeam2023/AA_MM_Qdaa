package QdaaStore.testCases.inventoryMonitorsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.inventoryMonitors.SolfaClassification;
import QdaaStore.pages.inventoryMonitors.SpendingOrderMonitoring;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SolfaClassificationTest extends TestBase {

    private SolfaClassification solfaClassification ;
    @Test
    public void setClosingFinYear(){
        solfaClassification = new SolfaClassification(driver);
        solfaClassification
                .navigateToSolfaClassificationPage();
        Assert.assertTrue(solfaClassification.solfaClassificationIsDisplayed());

    }

}
