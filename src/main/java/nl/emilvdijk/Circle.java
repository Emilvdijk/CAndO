package nl.emilvdijk;

class Circle {

  double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  Circle() {
    this.radius = 8;
  }

  double Diameter() {
    return radius * 2;
  }

  static double Diameter(double radius) {
    return radius * 2;
  }

  void setRadius(double radius) {
    this.radius = radius;
  }

  double CalcCircumference() {
    return (radius * 2) * Math.PI;
  }

  double CalcCircumference(double radius) {
    return (radius * 2) * Math.PI;
  }

  double CalcSurfaceArea() {
    return Math.PI * (radius * radius);
  }

  double CalcSurfaceArea(double radius) {
    return Math.PI * (radius * radius);
  }

  double CalcPoleDistance(int poles) {
    return this.CalcCircumference() / poles;
  }

  double CalcPoleAmount(double poleDistance) {
    return this.CalcCircumference() / poleDistance;
  }

}
