package com.ait.phonebook.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePAgeHelper homePage;

    public ApplicationManager(String browser){
        this.browser = browser;
    }
    public void init() {
        System.err.close(); //отключает вывод системных ошибок
        if(browser.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
        driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("microsoftEdge")){
        driver = new EdgeDriver();

        }
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePAgeHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePAgeHelper getHomePage() {
        return homePage;
    }
}
