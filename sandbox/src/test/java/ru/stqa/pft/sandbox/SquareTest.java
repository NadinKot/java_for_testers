package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nadin_Kot on 29.05.2016.
 */
public class SquareTest {

  @Test
  public void teseArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }
}
