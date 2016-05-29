package ru.stqa.pft.sandbox;

/**
 * Created by Nadin_Kot on 28.05.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double m, double n) {
    this.x = m;
    this.y = n;
  }

  public double dist( Point p2) {

    return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));

  }
}











/*Код до внесения метода, в классе Distance есть соответствующий закоментированный кусочек

public class Point {
  public double x;
  public double y;

    ///public Point(double m, double n) {
    ///this.x = m;
    ///this.y = n;

  }
}*/
