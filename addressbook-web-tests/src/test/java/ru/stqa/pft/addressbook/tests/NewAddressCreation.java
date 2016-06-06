package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class NewAddressCreation extends TestBase {

    @Test
    public void NewAddressCreation() {
        app.getContactHelper().addNewAddress();
        app.getContactHelper().fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test"));
        app.getContactHelper().submitAddressCreation();
        app.getNavigationHelper().returnToHomePage();
    }
}