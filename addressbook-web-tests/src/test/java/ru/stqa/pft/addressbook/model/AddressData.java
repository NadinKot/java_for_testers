package ru.stqa.pft.addressbook.model;

public class AddressData {
  private int id=Integer.MAX_VALUE;
  private String lastname;
  private String firstname;
  private String nickname;
  private String address;
  private String mobile;
  private String email;
  private String group;
  private String secondAddress;

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

  public AddressData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public AddressData withEmail(String email) {
    this.email = email;
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

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getSecondAddress() {
    return secondAddress;
  }

  public String getGroup() {
    return group;
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
