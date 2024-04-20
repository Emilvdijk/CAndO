package nl.emilvdijk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CircleTest {
    Circle circy = new Circle();
    Circle circy2 = new Circle(12);
    Circle circy3 = new Circle(0.5);

    @Test
    void diameter() {
        assertEquals(16,circy.Diameter());
        assertEquals(24,circy2.Diameter());
        assertEquals(1,circy3.Diameter());
      }

    @Test
    void testDiameter() {
        assertEquals(16,Circle.Diameter(8));
      }

    @Test
    void setRadius() {
        circy3.setRadius(2);
        assertEquals(2,circy3.radius);
      }

    @Test
    void calcCircumference() {
        assertEquals(Math.PI,circy3.CalcCircumference());
      }

    @Test
    void testCalcCircumference() {
        assertEquals(Math.PI,Circle.CalcCircumference(0.5));
      }

    @Test
    void calcSurfaceArea() {
        assertEquals(201.06192982974676,circy.CalcSurfaceArea());
        assertEquals(0.7853981633974483,circy3.CalcSurfaceArea());
      }

    @Test
    void testCalcSurfaceArea() {
        assertEquals(0.7853981633974483,Circle.CalcSurfaceArea(0.5));
        assertEquals(804.247719318987,Circle.CalcSurfaceArea(16));
      }

    @Test
    void calcPoleDistance() {
        assertEquals(10.053096491487338,circy.CalcPoleDistance(5));
        assertEquals(0.39269908169872414,circy3.CalcPoleDistance(8));

      }

    @Test
    void calcPoleAmount() {
        assertEquals(8,circy3.CalcPoleAmount(0.39269908169872414));
        assertEquals(0.39269908169872414,circy3.CalcPoleAmount(8));
        assertEquals(100.53096491487338,circy.CalcPoleAmount(0.5));
      }
}