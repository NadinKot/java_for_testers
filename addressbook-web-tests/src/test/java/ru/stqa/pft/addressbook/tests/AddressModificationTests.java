package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class AddressModificationTests extends TestBase {

  @Test
  public void testAddressModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new AddressData("SecondName", "MyName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null));
    }
    List<AddressData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectAddress(before.size()-1);
    app.getContactHelper().initAddressModification();
    AddressData address = new AddressData(before.get(before.size() - 1).getId(),"SecondName", "MyName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", "test_second_address");
    app.getContactHelper().fillAddressForm(address, false);
    app.getContactHelper().submitAddressModification();
    app.getNavigationHelper().returnToHomePage();
    List<AddressData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(address);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
