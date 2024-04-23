package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.procurement.ContractQuery;
import QdaaStore.pages.procurement.PurOrderSummary;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurOrderSummaryTest extends TestBase {

    private PurOrderSummary purOrderSummary ;
    @Test
    public void setCompetitionReqTest(){
        purOrderSummary = new PurOrderSummary(driver);
        purOrderSummary
                .navigateToPurOrderSummaryPage();
        Assert.assertTrue(purOrderSummary.purOrderSummaryIsDisplayed());
    }

}
