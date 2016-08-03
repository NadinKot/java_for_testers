package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nadin_Kot on 03.08.2016.
 */
public class DeleteContactFromAGroup extends TestBase  {

  @BeforeMethod
  public void ensurePreconditions(){

    if (app.db().contacts().size()==0){
      app.goTo().homePage();
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
              .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz"));//.withGroup("test1")
    }
    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("header1").withFooter("footer1"));
    }
  }


  @Test
  public void testDeleteContactFromAGroup(){
    app.goTo().homePage();
    GroupData group = app.db().groups().iterator().next();
    Contacts contacts = group.getContacts();
    if (contacts.size() == 0) {
      app.goTo().homePage();
      AddressData contact = app.db().contacts().iterator().next();
      app.contact().addToGroup(contact, group);
      contacts = app.db().groupsByUniqID(group).getContacts();
    }
    AddressData contact = contacts.iterator().next();
    Groups before = contact.getGroups();
    Contacts beforeContacts = app.db().groupsByUniqID(group).getContacts();
    app.contact().deleteFromGroup(contact, group);
    Groups after = app.db().contactByUniqID(contact).getGroups();
    Contacts afterContacts = app.db().groupsByUniqID(group).getContacts();
    assertThat(after, equalTo(before.without(group)));
    assertThat(afterContacts, equalTo(beforeContacts.without(contact)));
    System.out.println("group is " + group.getName());
    System.out.println("before: " + before.size() + "; After : " + after.size());
    System.out.println("beforeContacts: " + beforeContacts.size() + "; AfterContacts : " + afterContacts.size());
  }

}


