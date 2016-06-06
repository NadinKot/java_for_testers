package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class NewAddressCreation extends TestBase {

    @Test
    public void NewAddressCreation() {
        addNewAddress();
        fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test"));
        submitAddressCreation();
        returnToHomePage();
    }
}
