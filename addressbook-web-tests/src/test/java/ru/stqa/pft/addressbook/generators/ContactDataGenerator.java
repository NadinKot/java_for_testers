package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.AddressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nadin_Kot on 31.07.2016.
 */
public class ContactDataGenerator {

  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

    public static void main(String[] args) throws IOException {

      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander jCommander = new JCommander(generator);
      try {
        jCommander.parse(args);
      } catch(ParameterException ex){
        jCommander.usage();
        return;
      }
      generator.run();
    }

  private void run() throws IOException {
    List<AddressData> contacts = generateContact(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<AddressData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }


  private void saveAsXml(List<AddressData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AddressData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<AddressData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (AddressData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),contact.getLastname(),contact.getAddress(),contact.getHomePhone(),
              contact.getMobile(),contact.getWorkPhone(),contact.getEmail()));
    }
    writer.close();
  }

 private List<AddressData> generateContact(int count) {
    List<AddressData> contacts = new ArrayList<AddressData>();
    for (int i = 0; i<count; i++){
      contacts.add(new AddressData().withFirstname(String.format("MyName %s", i))
              .withLastname(String.format("SecondName %s", i)).withAddress(String.format("MyAddress %s", i))
              .withHomePhone(String.format("1112-%s", i)).withMobile(String.format("123456-%s", i)).withWorkPhone(String.format("222-%s", i))
              .withEmail(String.format("myname.secondname%s@e-mail.zz", i)));
    }
    return contacts;
  }
}
