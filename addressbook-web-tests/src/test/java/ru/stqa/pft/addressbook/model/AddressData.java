package ru.stqa.pft.addressbook.model;

public class AddressData {
  private int id;
  private final String lastname;
  private final String firstname;
  private final String nickname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String group;
  private final String secondAddress;

  public AddressData(String lastname, String firstname, String nickname, String address, String mobile, String email, String group, String secondAddress) {
    this.id = Integer.MAX_VALUE;
    this.lastname = lastname;
    this.firstname = firstname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
    this.secondAddress = secondAddress;
  }

  public AddressData(int id, String lastname, String firstname, String nickname, String address, String mobile, String email, String group, String secondAddress) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
    this.secondAddress = secondAddress;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;

  }

  @Override
  public int hashCode() {
    int result = lastname != null ? lastname.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }
}
