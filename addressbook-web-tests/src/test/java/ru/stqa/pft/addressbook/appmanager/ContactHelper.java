package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void returnToHomePage() {
    click(By.linkText("home page"));
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

  public void selectAddress(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteAddress() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }

  public void initAddressModification() {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));  }

  public void submitAddressModification() {
    click(By.name("update"));
  }

  public void createNewContact(AddressData addressData, boolean b) {
    addNewAddress();
    fillAddressForm(new AddressData("MyName", "SecondName", null, "MyAddress", "123456", "myname.secondname@e-mail.zz", "test1", null),true);
    submitAddressCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<AddressData> getContactList() {
    List<AddressData> addresses= new ArrayList<AddressData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      AddressData address = new AddressData(lastName, null, null, null, null, null, null, null);
      addresses.add(address);
    }
    return addresses;
  }
}

