package QdaaStore.testCases.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.assets.AppAssetTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetTypesTest  extends TestBase {


    private AppAssetTypes appAssetTypes ;
    @Test
    public void setAppAssetTypes(){
        appAssetTypes = new AppAssetTypes(driver);
        appAssetTypes
                .navigateToAppAssetTypesPage();
        Assert.assertTrue(appAssetTypes.appAssetTypesIsDisplayed());

    }
}
