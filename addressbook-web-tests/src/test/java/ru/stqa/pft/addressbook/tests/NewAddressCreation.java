package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class NewAddressCreation extends TestBase {

    @Test //(enabled = false)
    public void testAddressCreation() {
        app.goTo().homePage();
        List<AddressData> before = app.contact().list();
        AddressData address = new AddressData()
                .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
                .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1");
        app.contact().create(address);
        List<AddressData> after = app.contact().list();
        Assert.assertEquals( after.size(), before.size()+1);

        //address.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(address);
        Comparator<? super AddressData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}

