package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class DeleteAddressTests extends TestBase {

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
 public void testDeleteAddress() {
    Set<AddressData> before = app.contact().all();
    AddressData deletedAdress = before.iterator().next();
    app.contact().delete(deletedAdress);
    //app.getNavigationHelper().returnToHomePage();
    app.delay();
    Set<AddressData> after = app.contact().all();
    Assert.assertEquals( after.size(), before.size()-1);

    before.remove(deletedAdress);
    Assert.assertEquals(before,after);
  }

}
