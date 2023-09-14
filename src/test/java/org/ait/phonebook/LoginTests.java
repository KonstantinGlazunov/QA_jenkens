package org.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignoutButton();
        }
        app.getUser().clickOnLoginLink();
    }


    @Test
    public void loginPositiveTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("qq@qq.qq")
                .setPass( "Pass@1234"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().fillLoginRegistrationForm(new User().setPass( "Pass@1234"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAllertPresent());

    }

    @Test
    public void loginPositiveTestWithScreenCast() throws IOException, AWTException {
        app.getUser().deleteScreenCast();
        app.getUser().startRecording();
        app.getUser().fillLoginRegistrationFormForScreenCast(new User()
                .setEmail("qq@qq.qq")
                .setPass( "Pass@1234"));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(3000);
        //Assert.assertTrue(app.getUser().isSignOutButtonPresent());
app.getUser().stopRecording();
    }


}
