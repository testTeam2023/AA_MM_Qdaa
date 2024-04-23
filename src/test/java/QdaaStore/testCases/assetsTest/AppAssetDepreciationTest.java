package QdaaStore.testCases.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.assets.AppAssetDepreciation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetDepreciationTest extends TestBase {
    private AppAssetDepreciation appAssetDepreciation ;
    @Test
    public void setAppAssetDepreciation(){
        appAssetDepreciation = new AppAssetDepreciation(driver);
        appAssetDepreciation
                .navigateToAppAssetDepreciationPage();
        Assert.assertTrue(appAssetDepreciation.appAssetDepreciationIsDisplayed());

    }
}
