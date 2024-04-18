package nl.emilvdijk;

public class Rectangle {

  int length;
  int width;
  // FIXME afmaken en testen

  public Rectangle(int length, int width) {
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

  private int CalcSurfaceArea() {
    return length * width;
  }

  private int CalcSurfaceArea(int Length, int Width) {
    return Length * Width;
  }

  private int CalcCircumference() {
    return (length * 2) + (width * 2);
  }

  private int CalcCircumference(int length, int width) {
    return (length * 2) + (width * 2);
  }

  int CalcFittingIn(Rectangle rectangleBase) {
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

  double CalcPoleDistance(int poles) {
    return this.CalcCircumference() / poles;
  }

  double CalcPoleAmount(double poleDistance) {
    return this.CalcCircumference() / poleDistance;
  }
}
