package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class NewAddressCreation extends TestBase {

    @Test
    public void NewAddressCreation() {
        app.addNewAddress();
        app.fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test"));
        app.submitAddressCreation();
        app.returnToHomePage();
    }
}
