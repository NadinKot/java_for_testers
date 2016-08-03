package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nadin_Kot on 29.07.2016.
 */
public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new AddressData()
              .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
              .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz"));//.withGroup("test1")
    }
  }
  @Test
  public void testContactAddress(){
    app.goTo().homePage();
    AddressData contact = app.contact().all().iterator().next(); //загружаем список контактов
    AddressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); //Загружаем данные из формы редактирования для сравнения с тем что отображается на главной стр.

    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));

  }
  public static String cleaned(String address){
    return address.replaceAll("\\s","");
  }
}
