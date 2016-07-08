package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nadin_Kot on 06.06.2016.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
      && wd.findElement(By.tagName("h1")).getText().equals("Groups")
      && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintaible"))){
      return;
    }
    click(By.linkText("home"));
  }

}
