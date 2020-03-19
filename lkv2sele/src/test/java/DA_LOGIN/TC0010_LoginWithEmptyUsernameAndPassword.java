package DA_LOGIN;

import helper.Constant;
import org.testng.annotations.Test;
import testbase.TestBase;

public class TC0010_LoginWithEmptyUsernameAndPassword extends TestBase {

    /**
     * DA_LOGIN_TC0010
     * @author vi.dao
     */

    @Test (description = "TC0010 - Verify that the page works correctly for the case when no input entered to Password and Username field")
    public void TC0010(){
        reportLog("Step 1: Open Dash Board's login page");
        goToDashboardLoginPage();

        reportLog("Step 2: Click Login button without entering username and password");
        loginPage.login(Constant.REPOSITORY, "", "");

        reportLog("Step 3: Verify the error message, \"Please enter username!\", is displayed");
        loginPage.checkLoginErrorMessage(Constant.ERROR_MESSAGE_PLEASE_ENTER_USERNAME);
    }
}
