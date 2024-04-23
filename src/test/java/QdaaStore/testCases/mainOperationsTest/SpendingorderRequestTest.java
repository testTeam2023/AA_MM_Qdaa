package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.SpendingorderRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpendingorderRequestTest extends TestBase {

   private SpendingorderRequest spendingorderRequest ;
    @Test
    public void setSpendingorderRequestTest(){
        spendingorderRequest = new SpendingorderRequest(driver);
        spendingorderRequest
                .navigateToSpendingorderRequestPage();
        Assert.assertTrue(spendingorderRequest.spendingorderRequestIsDisplayed());

    }
}
