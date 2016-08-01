package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewAddressCreation extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line!=null){
      /*String[] split = line.split(";");
      list.add(new Object[]{new AddressData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2]).withHomePhone(split[3])
              .withMobile(split[4]).withWorkPhone(split[5]).withEmail(split[6])});*/
      json += line;
      line=reader.readLine();
    }
    Gson gson = new Gson();
    List<AddressData> contacts = gson.fromJson(json, new TypeToken<List<AddressData>>(){}.getType());
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
  }
  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line!=null){
      /*String[] split = line.split(";");
      list.add(new Object[]{new AddressData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2]).withHomePhone(split[3])
              .withMobile(split[4]).withWorkPhone(split[5]).withEmail(split[6])});*/
      xml += line;
      line=reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(AddressData.class);
    List<AddressData> contacts = (List<AddressData>) xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

    @Test (dataProvider = "validContactsFromJson")//(enabled = false)
    public void testAddressCreation(AddressData address) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/manchkin.png");
        /*AddressData address = new AddressData()
                .withLastname("SecondName").withFirstname("MyName").withAddress("MyAddress").withHomePhone("111")
                .withMobile("123456").withWorkPhone("222").withEmail("myname.secondname@e-mail.zz").withGroup("test1").withPhoto(photo);*/
        app.contact().create(address);
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(address.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void Direct(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/manchkin.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}

