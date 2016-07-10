package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class NewAddressCreation extends TestBase {

    @Test
    public void NewAddressCreation() {
        app.getNavigationHelper().goToHomePage();
        List<AddressData> before = app.getContactHelper().getContactList();
        app.getContactHelper().addNewAddress();
        app.getContactHelper().fillAddressForm(new AddressData("MyName", "SecondName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null),true);
        app.getContactHelper().submitAddressCreation();
        app.getNavigationHelper().returnToHomePage();
        List<AddressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals( after.size(), before.size()+1);
    }
}
