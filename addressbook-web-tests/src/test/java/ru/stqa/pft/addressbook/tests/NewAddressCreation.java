package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

public class NewAddressCreation extends TestBase {

    @Test //(enabled = false)
    public void testAddressCreation() {
        app.goTo().homePage();
        Set<AddressData> before = app.contact().all();
        AddressData address = new AddressData()
                .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
                .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1");
        app.contact().create(address);
        Set<AddressData> after = app.contact().all();
        Assert.assertEquals( after.size(), before.size()+1);

        //address.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        address.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(address);
        Assert.assertEquals(before,after);
    }
}

