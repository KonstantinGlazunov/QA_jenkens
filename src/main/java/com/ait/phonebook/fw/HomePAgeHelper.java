package com.ait.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePAgeHelper extends HelperBase {
    public HomePAgeHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//h1[(text()='Home Component')]")).size() > 0;
    }

    public void clickOnHomeLink() {
        click(By.xpath("//a[.='HOME']"));
    }
}
