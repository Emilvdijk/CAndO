package nl.emilvdijk;

/**
 * Hello world!
 */
public class CAndO {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    double x = 0.2;
    double y = 0.1;
    System.out.println(x * y);
    Circle niceCircleBro = new Circle();
    Circle niceCircleBro2 = new Circle(6);
    Rectangle niceRectangle = new Rectangle(1,2);
    Rectangle niceRectangle2 = new Rectangle(2,4);
    System.out.println(niceCircleBro.radius);
    System.out.println(niceCircleBro2.Diameter());
    System.out.println(Circle.Diameter(4));
    niceCircleBro2.setRadius(14);
    System.out.println(niceCircleBro2.Diameter());
    System.out.println(niceCircleBro.CalcCircumference());
    System.out.println(niceCircleBro.CalcSurfaceArea());
    System.out.println(niceRectangle.CalcFittingIn(niceRectangle2));

  }
}
