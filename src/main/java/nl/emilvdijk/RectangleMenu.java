package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangleMenu {

  static final ArrayList<Rectangle> rectanglesList = new ArrayList<>();

  private RectangleMenu() {
  }

  static void menu() {
    System.out.println("Rectangles Manager");
    Scanner myScanner = new Scanner(System.in);
    while (true) {
      System.out.println("""
                    
          1 list rectangles
          2 Create new rectangle
          3 Remove rectangle
          4 Calculate circumference
          5 Calculate circumference of an object
          6 Calculate Surface area
          7 Calculate Surface area of an object
          8 Calculate distance between fence poles based on amount of poles of an object
          9 Calculate amount of fence poles based on distance between poles of an object
          0 back
          """);

      while (!myScanner.hasNextInt()) {
        System.out.println("Please enter a number to choose.");
        myScanner.next();
      }

      switch (myScanner.nextLine()) {
        case "1":
          RectangleMenu.rectangleListPrinter();
          break;

        case "2":
          rectanglesList.add(RectangleManager.addRectangle());
          break;

        case "3":
          RectangleManager.deleteRectangle(rectanglesList);
          break;

        case "4":
          circumferenceCalc();
          break;

        case "5":
          circumferenceOfRectangleCalc();
          break;

        case "6":
          surfaceAreaCalc();
          break;

        case "7":
          surfaceAreaOfRectangleCalc();
          break;

        case "8":
          calcPoleDistanceOfRectangle();
          break;

        case "9":
          calcPoleAmountOfRectangle();
          break;

        case "0":
          return;

        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }

  private static void calcPoleAmountOfRectangle() {
    Scanner myScanner = new Scanner(System.in);
    if (rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate amount of poles");
    int y = 0;
    for (; y < rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, rectanglesList.get(y).name);
    }
    int choiceRectangle;
    do {
      choiceRectangle = myScanner.nextInt();
    } while (!(choiceRectangle >= 1 && choiceRectangle <= y));

    System.out.println("enter the distance between poles (can be decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    System.out.printf("amount of poles in the fence around %s is: %s",
        rectanglesList.get(choiceRectangle - 1).name,
        rectanglesList.get(choiceRectangle - 1).calcPoleAmount(myScanner.nextDouble()));
  }

  private static void calcPoleDistanceOfRectangle() {
    Scanner myScanner = new Scanner(System.in);
    if (rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate distance between poles");
    int y = 0;
    for (; y < rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, rectanglesList.get(y).name);
    }
    int choiceRectangle;
    do {
      choiceRectangle = myScanner.nextInt();
    } while (!(choiceRectangle >= 1 && choiceRectangle <= y));

    System.out.println("how many poles are in the fence");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    System.out.printf("distance between poles of %s is: %s",
        rectanglesList.get(choiceRectangle - 1).name,
        rectanglesList.get(choiceRectangle - 1).calcPoleDistance(myScanner.nextInt()));
  }

  private static void surfaceAreaOfRectangleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate surface area of");
    int y = 0;
    for (; y < rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, rectanglesList.get(y).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y));
    System.out.printf("surface area of %s is: %s", rectanglesList.get(choice - 1).name,
        rectanglesList.get(choice - 1).calcSurfaceArea());

  }

  private static void surfaceAreaCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter length");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int length = myScanner.nextInt();
    System.out.println("please enter width");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int width = myScanner.nextInt();
    System.out.printf("surface area is: %s", Rectangle.calcSurfaceArea(length, width));
  }

  private static void circumferenceOfRectangleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate circumference of");
    int y = 0;
    for (; y < rectanglesList.size(); y++) {
      System.out.printf(" %s  %s%n", y + 1, rectanglesList.get(y).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y));
    System.out.printf("circumference of %s is: %s", rectanglesList.get(choice - 1).name,
        rectanglesList.get(choice - 1).calcCircumference());
  }

  private static void circumferenceCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter length");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int length = myScanner.nextInt();
    System.out.println("please enter width");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int width = myScanner.nextInt();
    System.out.printf("circumference is: %s", Rectangle.calcCircumference(length, width));
  }


  private static void rectangleListPrinter() {
    if (rectanglesList.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Rectangle rectangle : rectanglesList) {
      rectangle.rectanglePrinter();
    }
  }

}
