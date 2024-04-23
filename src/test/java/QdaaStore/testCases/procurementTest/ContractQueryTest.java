package QdaaStore.testCases.procurementTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.CompetitionReq;
import QdaaStore.pages.procurement.ContractQuery;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContractQueryTest extends TestBase {
    private ContractQuery contractQuery ;
    @Test
    public void setCompetitionReqTest(){
        contractQuery = new ContractQuery(driver);
        contractQuery
                .navigateToContractQueryPage();
        Assert.assertTrue(contractQuery.contractQueryIsDisplayed());
    }


}
