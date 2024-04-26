package nl.emilvdijk;

import static java.lang.Math.sqrt;

public class Triangle extends Shape {

  private int side1;
  private int side2;
  private int side3;

  /**
   * constructor for triangle objects
   *
   * @param name  name of object
   * @param side3 side 3 length
   * @param side2 side 2 length
   * @param side1 side 1 length
   */
  public Triangle(String name, int side3, int side2, int side1) {
    super(name);
    this.side3 = side3;
    this.side2 = side2;
    this.side1 = side1;
  }

  /**
   * calculate and return area of triangle with herons formula
   *
   * @return area of triangle
   */
  double calcSurfaceArea() {
    return 0.25 * sqrt(
        (side1 + side2 + side3) * (-side1 + side2 + side3) * (side1 - side2 + side3) * (double) (
            side1 + side2 - side3));
  }

  /**
   * calculate and return area of triangle with herons formula
   *
   * @param side1 length of side 1 of triangle
   * @param side2 length of side 2 of triangle
   * @param side3 length of side 3 of triangle
   * @return area of triangle
   */
  static double calcSurfaceArea(int side1, int side2 , int side3) {
    return 0.25 * sqrt(
        (side1 + side2 + side3) * (-side1 + side2 + side3) * (side1 - side2 + side3) * (double) (
            side1 + side2 - side3));
  }

  /**
   * calculates circumference of triangle
   *
   * @return circumference of triangle
   */
  @Override
  double calcCircumference() {
    return side1 + side2 + (double) side3;
  }

  static double calcCircumference(int side1, int side2 , int side3) {
    return side1 + side2 + (double) side3;
  }

  /**
   * calculates distance between poles in a fence of a triangle object
   *
   * @param poles amount of poles in triangle object fence
   * @return distance between poles
   */
  @Override
  double calcPoleDistance(int poles) {
    return (this.calcCircumference() / poles);
  }

  /**
   * calculates amount of poles in a fence of a triangle object
   *
   * @param poleDistance distance between poles in triangle object fence
   * @return amount of poles
   */
  @Override
  int calcPoleAmount(double poleDistance) {
    return (int) (this.calcCircumference() / poleDistance);
  }

  /**
   * triangle object details printer
   */
  void printer() {
    System.out.printf("Name: %-15s side1: %-6s  side2: %-6s side3: %-6s %n", name, side1, side2,
        side3);
  }
}
