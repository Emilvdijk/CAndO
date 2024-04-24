package nl.emilvdijk;

class Circle extends Shape {

  private double radius;

  /**
   * circle object constructor
   * @param name name of new object
   * @param radius radius of circle object
   */
  Circle(String name,double radius) {
    super(name);
    this.radius = radius;
  }

  /**
   * circle object constructor which makes radius 8
   */
  Circle() {
    super("circle");
    this.radius = 8;
  }

  public double getRadius() {
    return radius;
  }

  /**
   * calculates the diameter of a circle object which is twice the radius
   * @return twice the radius is returned
   */
  double diameter() {
    return radius * 2;
  }

  /**
   * calculates the diameter of a circle object which is twice the radius
   * @param radius of circle to be calculated
   * @return twice the radius is returned
   */
  static double diameter(double radius) {
    return radius * 2;
  }

  /**
   * setter for radius of circle objects
   * @param radius new radius
   */
  void setRadius(double radius) {
    this.radius = radius;
  }

  /**
   * calculates circumference of circle object
   * @return circumference of circle object
   */
  double calcCircumference() {
    return (radius * 2) * Math.PI;
  }

  /**
   * calculates circumference of circle with given radius
   * @param radius radius to calculate with
   * @return circumference of circle
   */
  static double calcCircumference(double radius) {
    return (radius * 2) * Math.PI;
  }

  /**
   * calculates surface area of circle object
   *
   * @return surface area of the circle object
   */
  double calcSurfaceArea() {
    return Math.PI * (radius * radius);
  }

  /**
   * calculates surface area of a circle with given radius
   * @param radius radius to calculate with
   * @return surface area of the circle
   */
  static double calcSurfaceArea(double radius) {
    return Math.PI * (radius * radius);
  }

  /**
   * takes pole amount param and calculates what the distance is between poles in a circle object
   * @param poles amount of poles
   * @return distance between poles
   */
  @Override
  double calcPoleDistance(int poles) {
    return this.calcCircumference() / poles;
  }

  /**
   * calculates amount of poles needed in a circle object fence with given distance between poles
   * @param poleDistance distance between poles to calculate with
   * @return amount of poles
   */
  @Override
  int calcPoleAmount(double poleDistance) {
    return (int) (this.calcCircumference() / poleDistance);
  }

  /**
   * prints out circle object details
   */
  void printer() {
    System.out.printf(
        "Name: %-15s radius: %-6s%n",name,
        radius);
  }

}
