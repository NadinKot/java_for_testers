package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AddressData;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void addNewAddress() {
    click(By.linkText("add new"));
  }

  public void submitAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData) {
    type(By.name("firstname"),addressData.getFirstname());
    type(By.name("lastname"),addressData.getLastname());
    type(By.name("nickname"),addressData.getNickname());
    type(By.name("address"),addressData.getAddress());
    type(By.name("mobile"),addressData.getMobile());
    type(By.name("email"),addressData.getEmail());
    type(By.name("address2"),addressData.getSecondAddress());
  }

  public void selectAddress() {click(By.name("selected[]")); }

  public void deleteAddress() { click(By.name("delete"));}

  public void confirmationDeletition() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }
}
