package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class NewAddressCreation extends TestBase {

    @Test
    public void testAddressCreation() {
        app.getNavigationHelper().goToHomePage();
        List<AddressData> before = app.getContactHelper().getContactList();
        app.getContactHelper().addNewAddress();
        AddressData address = new AddressData("SecondName", "MyName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null);
        app.getContactHelper().fillAddressForm(address,true);
        app.getContactHelper().submitAddressCreation();
        app.getNavigationHelper().returnToHomePage();
        List<AddressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals( after.size(), before.size()+1);

        int max=0;
        for (AddressData g : after){
            if (g.getId()>max){
                max=g.getId();
            }
        }
        address.setId(max);
        before.add(address);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
