package nl.emilvdijk;

public class Rectangle {
  String name;

  int length;
  int width;

  public Rectangle(String name ,int length, int width) {
    this.name = name;
    this.length = length;
    this.width = width;
  }

  public Rectangle(int lengthAndWidth) {
    this.length = lengthAndWidth;
    this.width = lengthAndWidth;
  }

  public Rectangle() {
    this.length = 4;
    this.width = 2;
  }

  int calcSurfaceArea() {
    return length * width;
  }

  static int calcSurfaceArea(int length, int width) {
    return length * width;
  }

  int calcCircumference() {
    return (length * 2) + (width * 2);
  }

  static int calcCircumference(int length, int width) {
    return (length * 2) + (width * 2);
  }

  int calcFittingIn(Rectangle rectangleBase) {
    Rectangle rectangleFitter = this;
    double compare1 = rectangleBase.width / rectangleFitter.length;
    double compare2 = rectangleBase.length / rectangleFitter.width;
    int fitAmount = (int) compare1 * (int) compare2;
    compare1 = rectangleBase.width / rectangleFitter.width;
    compare2 = rectangleBase.length / rectangleFitter.length;
    if ((int) compare1 * (int) compare2 > fitAmount) {
      fitAmount = (int) compare1 * (int) compare2;
    }
    return fitAmount;
  }

  int calcFittingIn(double length, double width) {
    Rectangle rectangleFitter = this;
    double compare1 = width / rectangleFitter.length;
    double compare2 = length / rectangleFitter.width;
    int fitAmount = (int) compare1 * (int) compare2;
    compare1 = width / rectangleFitter.width;
    compare2 = length / rectangleFitter.length;
    if ((int) compare1 * (int) compare2 > fitAmount) {
      fitAmount = (int) compare1 * (int) compare2;
    }
    return fitAmount;
  }

  double calcPoleDistance(int poles) {
    return (this.calcCircumference() / poles);
  }

  double calcPoleAmount(double poleDistance) {
    return (this.calcCircumference() / poleDistance);
  }


  void rectanglePrinter() {
    System.out.printf(
        "Name: %-15s Length: %-6s  Width: %-6s %n",name,
        length, width);
  }
}

