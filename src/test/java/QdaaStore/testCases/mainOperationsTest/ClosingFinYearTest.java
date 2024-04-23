package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ClosingFinYear;
import QdaaStore.pages.mainOperations.CompetitionReq;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClosingFinYearTest extends TestBase {

    private ClosingFinYear closingFinYear ;
    @Test
    public void setClosingFinYear(){
        closingFinYear = new ClosingFinYear(driver);
        closingFinYear
                .navigateToClosingFinYearPage();
        Assert.assertTrue(closingFinYear.closingFinYearIsDisplayed());

    }

}
