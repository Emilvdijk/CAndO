package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class CircleMenu {

  static final ArrayList<Circle> circleList = new ArrayList<>();

  private CircleMenu() {
  }

  static void menu() {
    System.out.println("Circle Manager");
    Scanner myScanner = new Scanner(System.in);
    while (true) {
      System.out.println("""
                    
          1 list Circle
          2 Create new Circle
          3 Remove Circle
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
          CircleMenu.circleListPrinter();
          break;

        case "2":
          circleList.add(CircleManager.addCircle());
          break;

        case "3":
          CircleManager.deleteCircle(circleList);
          break;

        case "4":
          circumferenceCalc();
          break;

        case "5":
          circumferenceOfCircleCalc();
          break;

        case "6":
          surfaceAreaCalc();
          break;

        case "7":
          surfaceAreaOfCircleCalc();
          break;

        case "8":
          calcPoleDistanceOfCircle();
          break;

        case "9":
          calcPoleAmountOfCircle();
          break;

        case "0":
          return;

        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }

  private static void calcPoleAmountOfCircle() {
    Scanner myScanner = new Scanner(System.in);
    if (circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate amount of poles");
    int y = 0;
    for (; y < circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, circleList.get(y).name);
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
        circleList.get(choiceRectangle - 1).name,
        circleList.get(choiceRectangle - 1).calcPoleAmount(myScanner.nextDouble()));
  }

  private static void calcPoleDistanceOfCircle() {
    Scanner myScanner = new Scanner(System.in);
    if (circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate distance between poles");
    int y = 0;
    for (; y < circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, circleList.get(y).name);
    }
    int choiceCircle;
    do {
      choiceCircle = myScanner.nextInt();
    } while (!(choiceCircle >= 1 && choiceCircle <= y));

    System.out.println("how many poles are in the fence");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    System.out.printf("distance between poles of %s is: %s",
        circleList.get(choiceCircle - 1).name,
        circleList.get(choiceCircle - 1).calcPoleDistance(myScanner.nextInt()));
  }

  private static void surfaceAreaOfCircleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate surface area of");
    int y = 0;
    for (; y < circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, circleList.get(y).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y));
    System.out.printf("surface area of %s is: %s", circleList.get(choice - 1).name,
        circleList.get(choice - 1).calcSurfaceArea());

  }

  private static void surfaceAreaCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter radius (can be decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    double radius = myScanner.nextDouble();
    System.out.printf("surface area is: %s", Circle.calcSurfaceArea(radius));
  }

  private static void circumferenceOfCircleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate circumference of");
    int y = 0;
    for (; y < circleList.size(); y++) {
      System.out.printf(" %s  %s%n", y + 1, circleList.get(y).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y));
    System.out.printf("circumference of %s is: %s", circleList.get(choice - 1).name,
        circleList.get(choice - 1).calcCircumference());
  }

  private static void circumferenceCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter radius (can be a decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    double radius = myScanner.nextDouble();
    System.out.printf("circumference is: %s", Circle.calcCircumference(radius));
  }


  private static void circleListPrinter() {
    if (circleList.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Circle circle : circleList) {
      circle.circlePrinter();
    }
  }
}
