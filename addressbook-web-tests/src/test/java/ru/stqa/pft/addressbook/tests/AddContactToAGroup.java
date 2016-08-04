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
public class AddContactToAGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
              .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz"));
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("header1").withFooter("footer1"));
    }

  }

  @Test
  public void testAddContactToAGroup() {
    app.goTo().homePage();
    Contacts allContactsFromDB = app.db().contacts();
    Groups allGroupsFromDB = app.db().groups();
    AddressData contactForModify = allContactsFromDB.iterator().next();
    Groups assignedGroups = contactForModify.getGroups();
    GroupData groupForAdd;

    if (assignedGroups.size() == allGroupsFromDB.size()) {
      app.goTo().groupPage();
      GroupData newGroup = new GroupData().withName("New").withHeader("New").withFooter("New");
      app.group().create(newGroup);
      Groups newAddedGroup = app.db().groups();
      newAddedGroup.removeAll(allGroupsFromDB);
      groupForAdd = newAddedGroup.iterator().next();
    } else {
      allGroupsFromDB.removeAll(assignedGroups);
      groupForAdd = allGroupsFromDB.iterator().next();
    }
      app.goTo().homePage();
      app.contact().addToGroup(contactForModify, groupForAdd);
      app.goTo().homePage();
      Groups after = app.db().contactByUniqID(contactForModify.getId()).getGroups();
      assertThat(after, equalTo(assignedGroups.withAdded(groupForAdd)));
  }
}

