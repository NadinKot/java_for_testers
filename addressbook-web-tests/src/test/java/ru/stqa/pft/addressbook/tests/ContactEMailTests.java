package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nadin_Kot on 29.07.2016.
 */
public class ContactEMailTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
              .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz").withGroup("test1"));
    }
  }
  @Test
  public void testContactEMail(){
    app.goTo().homePage();
    AddressData contact = app.contact().all().iterator().next(); //загружаем список контактов
    AddressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); //Загружаем данные из формы редактирования для сравнения с тем что отображается на главной стр.

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(AddressData contact){
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s)-> !s.equals(""))
            .map(ContactEMailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String eMail){
    return eMail.replaceAll("\\s","");
  }
}
