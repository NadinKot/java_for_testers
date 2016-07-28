package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nadin_Kot on 28.07.2016.
 */
public class Contacts extends ForwardingSet<AddressData> {

  private Set<AddressData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<AddressData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<AddressData>();
  }

  @Override
  protected Set<AddressData> delegate() {
    return delegate;
  }

  public Contacts withAdded(AddressData contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }


  public Contacts without (AddressData contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
