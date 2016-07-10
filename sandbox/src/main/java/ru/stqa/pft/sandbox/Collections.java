package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nadin_Kot on 10.07.2016.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C++", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C++", "Python", "PHP");
    /*List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C++");*/

     /*for (int i= 0; i<languages.size(); i++) {
      System.out.println("Я хочу выучить язык " + languages.get(i));
    }*/

    for (String l : languages) {
      System.out.println("Я хочу выучить язык " + l);
    }
  }
}
