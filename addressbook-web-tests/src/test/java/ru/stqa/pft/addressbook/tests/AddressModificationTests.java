package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @Test
  public void testDeleteAddress() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectAddress();
    app.getContactHelper().initAddressModification();
    app.getContactHelper().submitAddressModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
