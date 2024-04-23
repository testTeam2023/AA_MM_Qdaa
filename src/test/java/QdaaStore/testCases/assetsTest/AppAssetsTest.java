package QdaaStore.testCases.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.assets.AppAssets;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetsTest extends TestBase {


    private AppAssets appAssets ;
    @Test
    public void setAppAssets(){
        appAssets = new AppAssets(driver);
        appAssets
                .navigateToAppAssetsPage();
        Assert.assertTrue(appAssets.appAssetsIsDisplayed());

    }
}
