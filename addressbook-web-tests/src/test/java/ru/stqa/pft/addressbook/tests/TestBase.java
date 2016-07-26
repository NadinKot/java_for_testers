package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;


/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  /*Выше происходит делегирование другому классу ApplicationManager, появляется новый объект класса ApplicationManager с типом ApplicationManager.
  Теперь во вспомогательных методах Объект типа ApplicationManager выполняет некоторое действие арр.___*/

  //Общие методы для всех тестов, Фикстура

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
