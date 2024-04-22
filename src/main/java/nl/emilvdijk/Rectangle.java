package nl.emilvdijk;

public class Rectangle {

  private String name;
  private int length;
  private int width;

  /**
   * rectangle object constructor
   * @param name name of rectangle object
   * @param length length of rectangle object
   * @param width width of rectangle object
   */
  public Rectangle(String name ,int length, int width) {
    this.name = name;
    this.length = length;
    this.width = width;
  }

  /**
   * rectangle object constructor which makes length and width the same
   * @param lengthAndWidth makes length and width of rectangle object this number
   */
  public Rectangle(int lengthAndWidth) {
    this.length = lengthAndWidth;
    this.width = lengthAndWidth;
  }

  /**
   * rectangle object constructor which makes length 4 and width 2
   */
  public Rectangle() {
    this.length = 4;
    this.width = 2;
  }

  /**
   * calculates surface area of rectangle object
   * @return surface area
   */
  int calcSurfaceArea() {
    return length * width;
  }

  public String getName() {
    return name;
  }

  public int getWidth() {
    return width;
  }

  public int getLength() {
    return length;
  }

  /**
   * calculates surface area of rectangle with given length and width
   * @param length length to calculate with
   * @param width width to calculate with
   * @return surface area
   */
  static int calcSurfaceArea(int length, int width) {
    return length * width;
  }

  /**
   * calculates circumference of rectangle object
   * @return circumference
   */
  int calcCircumference() {
    return (length * 2) + (width * 2);
  }

  /**
   * calculates circumference of rectangle with given length and width
   * @param length length to calculate with
   * @param width width to calculate with
   * @return circumference
   */
  static int calcCircumference(int length, int width) {
    return (length * 2) + (width * 2);
  }

  /**
   * calculates how many times a rectangle object fits inside another rectangle object
   * @param rectangleBase bigger rectangle object to try and fit into
   * @return runs an overloaded method which calculates fitting
   */
  int calcFittingIn(Rectangle rectangleBase) {
    return calcFittingIn(rectangleBase.length, rectangleBase.width);
  }

  /**
   * calculates how many times a rectangle object fits inside another rectangle of given size
   * @param length length of bigger rectangle
   * @param width width of bigger rectangle
   * @return amount of times it fits
   */
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


  /**
   * calculates distance between poles in a fence of a rectangle object
   * @param poles amount of poles in rectangle object fence
   * @return distance between poles
   */
  double calcPoleDistance(int poles) {
    return ((double) this.calcCircumference() / poles);
  }

  /**
   * calculates amount of poles in a fence of a rectangle object
   * @param poleDistance distance between poles in rectangle object fence
   * @return amount of poles
   */
  double calcPoleAmount(double poleDistance) {
    return (this.calcCircumference() / poleDistance);
  }

  /**
   * prints out rectangle object details
   */
  void rectanglePrinter() {
    System.out.printf(
        "Name: %-15s Length: %-6s  Width: %-6s %n",name,
        length, width);
  }

}

