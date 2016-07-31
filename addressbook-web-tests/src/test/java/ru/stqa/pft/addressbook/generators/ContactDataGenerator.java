package ru.stqa.pft.addressbook.generators;

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
    public static void main(String[] args) throws IOException {
      int count = Integer.parseInt(args[0]);
      File file = new File(args[1]);

      List<AddressData> contacts = generateContact(count);
      save(contacts, file);
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
