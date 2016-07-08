package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void addNewAddress() {
    click(By.linkText("add new"));
  }

  public void submitAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    type(By.name("firstname"),addressData.getFirstname());
    type(By.name("lastname"),addressData.getLastname());
    type(By.name("nickname"),addressData.getNickname());
    type(By.name("address"),addressData.getAddress());
    type(By.name("mobile"),addressData.getMobile());
    type(By.name("email"),addressData.getEmail());
    type(By.name("address2"),addressData.getSecondAddress());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectAddress() {click(By.name("selected[]")); }

  public void deleteAddress() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }

  public void initAddressModification() {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));  }

  public void submitAddressModification() {
    click(By.name("update"));
  }
}
