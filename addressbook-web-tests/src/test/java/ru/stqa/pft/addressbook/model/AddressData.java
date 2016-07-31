package ru.stqa.pft.addressbook.model;

import java.io.File;

public class AddressData {
  private int id=Integer.MAX_VALUE;
  private String lastname;
  private String firstname;
  private String nickname;
  private String address;
  private String homePhone;
  private String mobile;
  private String workPhone;
  private String email;
  private String email2;
  private String email3;
  private String group;
  private String secondAddress;
  private String allPhones;
  private String allEmails;
  private String contactDetails;
  private File photo;


  public AddressData withContactDetails(String contactDetails) {
    this.contactDetails = contactDetails;
    return this;
  }

  public AddressData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public AddressData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public AddressData withId(int id) {
    this.id = id;
    return this;
  }

  public AddressData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public AddressData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public AddressData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public AddressData withAddress(String address) {
    this.address = address;
    return this;
  }

  public AddressData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public AddressData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public AddressData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public AddressData withEmail(String email) {
    this.email = email;
    return this;
  }

  public AddressData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public AddressData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public AddressData withGroup(String group) {
    this.group = group;
    return this;
  }

  public AddressData withSecondAddress(String secondAddress) {
    this.secondAddress = secondAddress;
    return this;
  }

  public AddressData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public int getId() {
    return id;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }
  public String getMobile() {
    return mobile;
  }
  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getSecondAddress() {
    return secondAddress;
  }

  public String getGroup() {
    return group;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getContactDetails() {
    return contactDetails;
  }

  public File getPhoto() {
    return photo;
  }


  @Override
  public String toString() {
    return "AddressData{" +
            "lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressData that = (AddressData) o;

    if (id != that.id) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }
}
