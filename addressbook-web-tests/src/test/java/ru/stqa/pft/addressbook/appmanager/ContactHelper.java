package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void add() {
    click(By.linkText("add new"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    type(By.name("lastname"),addressData.getLastname());
    type(By.name("firstname"),addressData.getFirstname());
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

  public void selectAddressById(int id) {
    wd.findElement(By.xpath("//input[@value='"+id+"']")).click(); //cssSelector("input[value'" + id + "']"
  }

  public void deleteAddress() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }

  public void initAddressModification() {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));  }

  public void submitAddressModification() {
    click(By.name("update"));
  }

  public void create(AddressData addressData) {
    add();
    fillAddressForm(new AddressData()
            .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress")
            .withMobile("123456").withEmail("myname.secondname@e-mail.zz").withGroup("test1"),true);
    submitAddressCreation();
    returnToHomePage();
  }

  public void modify(AddressData address) {
    selectAddressById(address.getId());
    initAddressModification();
    fillAddressForm(address, false);
    submitAddressModification();
    returnToHomePage();
  }

  public void delete(AddressData address) {
    selectAddressById(address.getId());
    deleteAddress();
    alert();
  }

  /*
  public boolean isThereAContact() {
   return isElementPresent(By.name("selected[]"));

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
  */

  public Set<AddressData> all() {
    Set<AddressData> addresses= new HashSet<AddressData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText(); //  .//tr[@name='entry']/td[2]
      String firstName = element.findElement(By.xpath(".//td[3]")).getText(); //  .//tr[@name='entry']/td[3]
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      addresses.add(new AddressData().withId(id).withLastname(lastName).withFirstname(firstName));
    }
    return addresses;
  }

}

