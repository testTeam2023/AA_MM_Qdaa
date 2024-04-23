package QdaaStore.testCases.assetsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.assets.NewAddedAssets;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewAddedAssetsTest  extends TestBase {

    private NewAddedAssets newAddedAssets ;
    @Test
    public void setNewAddedAssets(){
        newAddedAssets = new NewAddedAssets(driver);
        newAddedAssets
                .navigateToNewAddedAssetsPage();
        Assert.assertTrue(newAddedAssets.newAddedAssetsIsDisplayed());

    }

}
