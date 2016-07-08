package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @Test
  public void testAddressModification() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectAddress();
    app.getContactHelper().initAddressModification();
    app.getContactHelper().fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", "test_second_address"), false);
    app.getContactHelper().submitAddressModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
