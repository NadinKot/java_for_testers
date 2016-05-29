package ru.stqa.pft.sandbox;

/**
 * Created by Nadin_Kot on 29.05.2016.
 */
public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x = 2;
    p1.y = -1;

    Point p2 = new Point();
    p2.x = 1;
    p2.y = 0;

    System.out.println ("Расстояние между точками  = " + dist(p1, p2));
  }

  public static double dist(Point p1, Point p2) {

    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

  }
}
