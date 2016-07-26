package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size()==0){
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
              .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1"));
    }
  }

  @Test //(enabled = false)
  public void testAddressModification() {
    List<AddressData> before = app.contact().list();
    int index = before.size() - 1;
    AddressData address = new AddressData()
            .withId(before.get(index).getId()).withLastname("SecondName").withFirstname("MyName").withNickname("Nick").withAddress("MyAddress")
            .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1").withSecondAddress("test_second_address");
    app.contact().modify(index, address);
    List<AddressData> after = app.contact().list();
    Assert.assertEquals( after.size(), before.size());

    before.remove(index);
    before.add(address);
    Comparator<? super AddressData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
