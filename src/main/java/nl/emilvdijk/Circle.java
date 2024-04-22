package nl.emilvdijk;

class Circle {

  String name;
  double radius;

  Circle(String name,double radius) {
    this.name = name;
    this.radius = radius;
  }

  Circle() {
    this.radius = 8;
  }

  double diameter() {
    return radius * 2;
  }

  static double diameter(double radius) {
    return radius * 2;
  }

  void setRadius(double radius) {
    this.radius = radius;
  }

  double calcCircumference() {
    return (radius * 2) * Math.PI;
  }

  static double calcCircumference(double radius) {
    return (radius * 2) * Math.PI;
  }

  double calcSurfaceArea() {
    return Math.PI * (radius * radius);
  }

  static double calcSurfaceArea(double radius) {
    return Math.PI * (radius * radius);
  }

  double calcPoleDistance(int poles) {
    return this.calcCircumference() / poles;
  }

  double calcPoleAmount(double poleDistance) {
    return this.calcCircumference() / poleDistance;
  }

  void circlePrinter() {
    System.out.printf(
        "Name: %-15s radius: %-6s%n",name,
        radius);
  }

}
