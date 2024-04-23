package QdaaStore.testCases.mainOperationsTest;

import QdaaStore.basess.TestBase;
import QdaaStore.pages.mainOperations.ReturnsDepartmentRequest;
import QdaaStore.pages.mainOperations.SpendingorderRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnsDepartmentRequestTest extends TestBase {
    private ReturnsDepartmentRequest returnsDepartmentRequest ;
    @Test
    public void setReturnsDepartmentRequest(){
        returnsDepartmentRequest = new ReturnsDepartmentRequest(driver);
        returnsDepartmentRequest
                .navigateToReturnsDepartmentRequestPage();
        Assert.assertTrue(returnsDepartmentRequest.returnDepartmentRequestIsDisplayed());

    }

}
