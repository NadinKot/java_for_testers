package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
              .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1"));
    }
  }

  @Test //(enabled = false)
  public void testAddressModification() {
    Set<AddressData> before = app.contact().all();
    AddressData modifiedAddress = before.iterator().next();
    AddressData address = new AddressData()
            .withId(modifiedAddress.getId()).withLastname("SecondName").withFirstname("MyName").withNickname("Nick").withAddress("MyAddress")
            .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1").withSecondAddress("test_second_address");
    app.contact().modify(address);
    Set<AddressData> after = app.contact().all();
    Assert.assertEquals( after.size(), before.size());

    before.remove(modifiedAddress);
    before.add(address);
    Assert.assertEquals(before,after);
  }


}
