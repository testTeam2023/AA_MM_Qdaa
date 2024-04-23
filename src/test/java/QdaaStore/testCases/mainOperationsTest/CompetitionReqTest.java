package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.CompetitionReq;
import QdaaStore.pages.mainOperations.Inventory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompetitionReqTest extends TestBase {

    private CompetitionReq competitionReq ;
    @Test
    public void setCompetitionReqTest(){
        competitionReq = new CompetitionReq(driver);
        competitionReq
                .navigateToCompetitionReqPage();
        Assert.assertTrue(competitionReq.competitionReqIsDisplayed());

    }
}
