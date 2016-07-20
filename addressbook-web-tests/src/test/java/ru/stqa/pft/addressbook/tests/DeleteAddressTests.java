package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class DeleteAddressTests extends TestBase {

  @Test
 public void testDeleteAddress() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new AddressData("MyName", "SecondName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null));
    }
    List<AddressData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectAddress(before.size()-1);
    app.getContactHelper().deleteAddress();
    app.getContactHelper().alert();
    //app.getNavigationHelper().returnToHomePage();
    app.delay();
    List<AddressData> after = app.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size()-1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);
  }
}
