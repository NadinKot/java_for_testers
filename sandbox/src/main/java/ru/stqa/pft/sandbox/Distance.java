package ru.stqa.pft.sandbox;

/**
 * Created by Nadin_Kot on 29.05.2016.
 */
public class Distance {

  public static void main(String[] args) {

   Point p1 = new Point(2,1);
   Point p2 = new Point(1,1);

    System.out.println ("Расстояние между точками с использованием функции  = " + dist(p1, p2));

    System.out.println ("Расстояние между точками с использованием метода класса Point  = " + p1.dist( p2));
  }

  public static double dist(Point p1, Point p2) {

    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

  }
}







/*Код до внесения метода в классе Point, соответствует закоментированному кусочку класса Point

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x = 2;
    p1.y = -1;

    Point p2 = new Point();
    p2.x = 1;
    p2.y = 0;

   //// Point p1 = new Point(2,2);
    ////Point p2 = new Point(1,1);


    System.out.println ("Расстояние между точками  = " + dist(p1, p2));
  }

  public static double dist(Point p1, Point p2) {

    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));

  }
}*/
