package ru.stqa.pft.addressbook.model;

public class AddressData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String address;
  private final String mobile;
  private final String email;
  private final String secondAddress;

  public AddressData(String firstname, String lastname, String nickname, String address, String mobile, String email, String secondAddress) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.secondAddress = secondAddress;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
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
}
