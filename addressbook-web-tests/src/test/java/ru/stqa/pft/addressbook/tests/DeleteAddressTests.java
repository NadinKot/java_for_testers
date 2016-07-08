package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class DeleteAddressTests extends TestBase {

  @Test
 public void testDeleteAddress() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new AddressData("MyName", "SecondName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null),true);
    }
    app.getContactHelper().selectAddress();
    app.getContactHelper().deleteAddress();
    app.getContactHelper().alert();
  }
}
