package org.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignoutButton();
        }
        app.getUser().clickOnLoginLink();
    }




    @Test
    public void existedUserRegistrationNegativeTest() {

        app.getUser().fillLoginRegistrationForm(new User().setEmail("qq@qq.qq").setPass( "Pass@1234"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAllertPresent());
    }

}
