package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
    save(contacts, new File(file));
  }

  private static void save(List<AddressData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (AddressData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s\n", contact.getFirstname(),contact.getLastname(),contact.getAddress(),contact.getMobile()));
    }
    writer.close();
  }

 private static List<AddressData> generateContact(int count) {
    List<AddressData> contacts = new ArrayList<AddressData>();
    for (int i = 0; i<count; i++){
      contacts.add(new AddressData().withFirstname(String.format("MyName %s", i))
              .withLastname(String.format("SecondName %s", i)).withAddress(String.format("MyAddress %s", i))
              .withMobile(String.format("1112-%s", i)));
    }
    return contacts;
  }
}
