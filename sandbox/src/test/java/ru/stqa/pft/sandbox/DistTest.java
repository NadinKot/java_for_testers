package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nadin_Kot on 29.05.2016.
 */

public class DistTest {

  @Test
  public void testDist(){

    Point p1 = new Point(2,1);
    Point p2 = new Point(1,1);
    //assert p1.dist(p2) >=0;
    Assert.assertTrue(p1.dist(p2) >=0);
  }

  @Test
  public void testDist2(){

    Point p1 = new Point(2,1);
    Point p2 = new Point(1,1);
    //для указанных выше значений;
    Assert.assertEquals(p1.dist(p2),1.0);
  }
}
