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
    Contacts before = app.contact().all();
    AddressData deletedAdress = before.iterator().next();
    app.contact().delete(deletedAdress);
    //app.getNavigationHelper().returnToHomePage();
    app.delay();
    Contacts after = app.contact().all();
    assertThat( after.size(), equalTo(before.size()-1));
    assertThat(after, equalTo(before.without(deletedAdress)));
  }

}
