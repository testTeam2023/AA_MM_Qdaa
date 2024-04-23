package QdaaStore.testCases.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.assets.AppAssetDisposal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppAssetDisposalTest  extends TestBase {

    private AppAssetDisposal appAssetDisposal ;
    @Test
    public void setAppAssetDisposal(){
        appAssetDisposal = new AppAssetDisposal(driver);
        appAssetDisposal
                .navigateToAppAssetDisposalPage();
        Assert.assertTrue(appAssetDisposal.appAssetDisposalIsDisplayed());

    }
}
