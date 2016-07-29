package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
              .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz").withGroup("test1"));
    }
  }

  @Test //(enabled = false)
  public void testAddressModification() {
    Contacts before = app.contact().all();
    AddressData modifiedAddress = before.iterator().next();
    AddressData address = new AddressData()
            .withId(modifiedAddress.getId()).withLastname("SecondName").withFirstname("MyName").withNickname("Nick").withAddress("MyAddress").withHomePhone("111")
            .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz").withGroup("test1").withSecondAddress("test_second_address");
    app.contact().modify(address);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedAddress).withAdded(address)));
  }


}
