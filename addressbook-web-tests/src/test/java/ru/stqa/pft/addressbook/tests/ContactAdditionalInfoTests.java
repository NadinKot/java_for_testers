package ru.stqa.pft.addressbook.tests;

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
public class ContactAdditionalInfoTests extends TestBase {

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
  public void testContactAdditionalInfo(){
    app.goTo().homePage();
    AddressData contact = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    AddressData contactInfoFromDetails = app.contact().infoFromDetails(contact);

    String editPageInfo = cleaned(mergeEditInfo(contactInfoFromEditForm));
    String detailsPageInfo = cleanDetail(contactInfoFromDetails.getContactDetails());
    assertThat((editPageInfo), equalTo(detailsPageInfo));
  }


  private String mergeEditInfo(AddressData contact) {
    String fullName = contact.getFirstname()+" "+contact.getLastname();
    String homePhone = "";
    String mobilePhone = "";
    String workPhone = "";
    String eMail = "";
    String eMail2 = "";
    String eMail3 = "";


    if(!contact.getHomePhone().equals("")){
      homePhone = "H: " + contact.getHomePhone();
    }
    if (!contact.getMobile().equals("")){
      mobilePhone = "M: " + contact.getMobile();
    }
    if (!contact.getWorkPhone().equals("")){
      workPhone = "W: " + contact.getWorkPhone();
    }
    if (!contact.getEmail().equals("")){
      eMail = contact.getEmail()+" (www.e-mail.zz)";
    }
    if (!contact.getEmail2().equals("")){
      eMail2 = contact.getEmail2()+" (www.e-mail.zz)";
    }
    if (!contact.getEmail3().equals("")){
      eMail3 = contact.getEmail3()+" (www.e-mail.zz)";
    }

    return  Arrays.asList(fullName,contact.getNickname(),contact.getAddress(), homePhone,
            mobilePhone, workPhone, eMail, eMail2, eMail3,
            contact.getSecondAddress()).stream().filter((s) -> !s.equals(""))
            .map(ContactAdditionalInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String details){
    return details.replaceAll("\\s", "");
  }

  public static String cleanDetail(String details){

    int pos = details.indexOf("Member of:");
    return details.substring(0,pos).replace("Member of:","").replaceAll("\\s", "");
  }
}





