package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
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

        address.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(address);
        Comparator<? super AddressData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
