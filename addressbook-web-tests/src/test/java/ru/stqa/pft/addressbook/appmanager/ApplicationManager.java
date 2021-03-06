package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class ApplicationManager {
  private final Properties properties;

  WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  /* делегирование GroupHelper, как и в TestBase->ApplicationManager
  Нет продолжения  = new GroupHelper(wd); т.е. нет инициализации, а есть только декларирование, поскольку ниже мы задаем обращение к конструктору
   */
  private ContactHelper contactHelper;
  private String browser;
  private DbHelper dbHelper;

  public ApplicationManager(String browser){
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new DbHelper();

    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    /*Ниже идут конструкторы*/
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"),properties.getProperty("web.adminPassword"));
    contactHelper = new ContactHelper(wd);

  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public DbHelper db(){
    return dbHelper;
  }

  public void delay() {
    wd.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
  }
  }

