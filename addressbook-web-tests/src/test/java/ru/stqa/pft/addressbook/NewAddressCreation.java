package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class NewAddressCreation extends TestBase {

    @Test
    public void NewAddressCreation() {
        addNewAddress();
        fillAddressForm(new AddressData("MyName", "SecondName", "Nick", "MyAddress", "123456", "myname.secondname@e-mail.zz", "test"));
        submitAddressCreation();
        returnToHomePage();
    }
}
