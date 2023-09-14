package com.ait.phonebook.fw;

import com.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink()  {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnSignoutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[text()='LOGIN']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[(text()='Registration')]"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPass());
    }

    public void fillLoginRegistrationFormForScreenCast(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        pause(500);
        type(By.cssSelector("[placeholder='Password']"), user.getPass());
    pause(500);
    }

    public boolean isSignOutButtonPresent() {
        return isHomeComponentPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }



    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm(new User().setEmail("qq@qq.qq").setPass("Pass@1234"));
        clickOnLoginButton();
    }
}
