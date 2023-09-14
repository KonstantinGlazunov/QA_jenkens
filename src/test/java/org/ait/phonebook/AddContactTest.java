package org.ait.phonebook;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignoutButton();
        }
        app.getUser().login();
        app.getContact().clickOnAddLink();
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

    @Test
    public void addPositiveTest() {

        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setSurname("Adams")
                .setPhone("1234567890")
                .setEmail("adam@qq.qq")
                .setAddress("Koblenz")
                .setDescription("goalKeeper"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));
    }



    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void addPositiveTestFromDataProvider(String name, String surname, String phone, String email, String address, String description) {

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }



    @Test(dataProvider = "newContactWithCSVFile", dataProviderClass = DataProviders.class)
    public void addPositiveTestFromDataProviderWithCSV(Contact contact) {

        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        app.getContact().pause(1);
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()), "1");
    }

}
