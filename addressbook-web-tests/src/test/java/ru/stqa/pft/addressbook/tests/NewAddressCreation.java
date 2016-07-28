package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewAddressCreation extends TestBase {

    @Test //(enabled = false)
    public void testAddressCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        AddressData address = new AddressData()
                .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
                .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1");
        app.contact().create(address);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()+1));
        assertThat(after, equalTo(
                before.withAdded(address.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
}

