package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.List;

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

  public void fillAddressForm(AddressData addressData) {
    type(By.name("lastname"),addressData.getLastname());
    type(By.name("firstname"),addressData.getFirstname());
    type(By.name("nickname"),addressData.getNickname());
    type(By.name("address"),addressData.getAddress());
    type(By.name("home"),addressData.getHomePhone());
    type(By.name("mobile"),addressData.getMobile());
    type(By.name("work"),addressData.getWorkPhone());
    type(By.name("email"),addressData.getEmail());
    type(By.name("email2"),addressData.getEmail2());
    type(By.name("email3"),addressData.getEmail3());
    type(By.name("address2"),addressData.getSecondAddress());
    //attache(By.name("photo"),addressData.getPhoto());
    }

  public void selectAddressById(int id) {
    //wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    wd.findElement(By.xpath("//input[@id='"+id+"']")).click();
  }

  public void deleteAddress() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));  }

  public void initAddressModification(int id) {click(By.xpath("//input[@value='"+id+"']//..//../td[8]/a/img"));  }

  public void openDetails(int id) {click(By.xpath("//input[@value='"+id+"']//..//../td[7]/a/img"));  }

  public void submitAddressModification() {
    click(By.name("update"));
  }

  public void chooseGroupForAdd(String name) {
    new Select (wd.findElement(By.xpath("//select[@name='to_group']"))).selectByVisibleText(name);
  }

  public void chooseGroupForDelete(String name) {
    new Select (wd.findElement(By.xpath("//form[@id='right']/select[@name='group']"))).selectByVisibleText(name);
  }

  public void create(AddressData address) {
    add();
    File photo = new File("src/test/resources/manchkin.png");
    fillAddressForm(address);
    /*fillAddressForm(new AddressData()
            .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
            .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz").withGroup("test1").withPhoto(photo));*/
    submitAddressCreation();
    contactCache=null;
    returnToHomePage();
  }

  public void modify(AddressData address) {
    initAddressModification(address.getId());
    fillAddressForm(address);
    submitAddressModification();
    contactCache=null;
    returnToHomePage();
  }

  public void delete(AddressData address) {
    selectAddressById(address.getId());
    deleteAddress();
    contactCache=null;
    alert();
  }

  public void addToGroup(AddressData address, GroupData group) {
    selectAddressById(address.getId());
    chooseGroupForAdd(group.getName());
    click(By.name("add"));
  }

  public void deleteFromGroup(AddressData address, GroupData group) {
    chooseGroupForDelete(group.getName());
    selectAddressById(address.getId());
    click(By.name("remove"));
  }

  /*
  public boolean isThereAContact() {
   return isElementPresent(By.name("selected[]")); */

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String lastName = element.findElement(By.xpath(".//td[2]")).getText(); //  .//tr[@name='entry']/td[2]
      String firstName = element.findElement(By.xpath(".//td[3]")).getText(); //  .//tr[@name='entry']/td[3]
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new AddressData().withId(id).withLastname(lastName).withFirstname(firstName).withAddress(address)
              .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public AddressData infoFromEditForm(AddressData contact){
    initAddressModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String eMail = wd.findElement(By.name("email")).getAttribute("value");
    String eMail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String eMail3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new AddressData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withNickname(nickname)
            .withAddress(address).withHomePhone(home).withMobile(mobile).withWorkPhone(work)
            .withEmail(eMail).withEmail2(eMail2).withEmail3(eMail3).withSecondAddress(address2);
  }

  public AddressData infoFromDetails(AddressData contact){
    openDetails(contact.getId());
    String info = wd.findElement(By.xpath(".//div[@id='content']")).getText();
    wd.navigate().back();
    return new AddressData().withId(contact.getId()).withContactDetails(info);
  }

}

