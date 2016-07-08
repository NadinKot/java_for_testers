package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @Test
  public void testAddressModification() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new AddressData("MyName", "SecondName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null),true);
    }
    app.getContactHelper().selectAddress();
    app.getContactHelper().initAddressModification();
    app.getContactHelper().fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", "test_second_address"), false);
    app.getContactHelper().submitAddressModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
