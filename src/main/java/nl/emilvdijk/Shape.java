package nl.emilvdijk;

abstract class Shape {
  protected String name;

  protected Shape(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  abstract double calcSurfaceArea();

  abstract double calcCircumference();

  /**
   * calculates distance between poles in a fence of a rectangle object
   *
   * @param poles amount of poles in rectangle object fence
   * @return distance between poles
   */
  double calcPoleDistance(int poles) {
    return (this.calcCircumference() / poles);
  }

  /**
   * calculates amount of poles in a fence of a rectangle object
   *
   * @param poleDistance distance between poles in rectangle object fence
   * @return amount of poles
   */
  int calcPoleAmount(double poleDistance) {
    return (int) (this.calcCircumference() / poleDistance);
  }

  abstract String toFormattedString();

}
