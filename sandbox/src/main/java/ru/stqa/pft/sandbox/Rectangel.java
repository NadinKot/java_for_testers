package ru.stqa.pft.sandbox;

/**
 * Created by Nadin_Kot on 28.05.2016.
 */
public class Rectangel {
  public double a;
  public double b;

  public Rectangel (double a, double b){
    this.a=a;
    this.b=b;
  }

  public double area () {
    return this.a*this.b;
  }
}
