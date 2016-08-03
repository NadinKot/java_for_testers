package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nadin_Kot on 28.07.2016.
 */
public class ContactPhoneTests extends TestBase {

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
  public void testContactPhones(){
    app.goTo().homePage();
    AddressData contact = app.contact().all().iterator().next(); //загружаем список контактов
    AddressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); //Загружаем данные из формы редактирования для сравнения с тем что отображается на главной стр.

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    /*assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));*/
  }

  private String mergePhones(AddressData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobile(),contact.getWorkPhone())
            .stream().filter((s)-> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
              }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
