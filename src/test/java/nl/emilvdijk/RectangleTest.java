package nl.emilvdijk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle recy = new Rectangle();
    Rectangle recy2 = new Rectangle(8);
    Rectangle recy3 = new Rectangle(1,4);
    Rectangle recy4 = new Rectangle(4,1);



    @Test
    void calcSurfaceArea() {
        assertEquals( 8,recy.CalcSurfaceArea());

      }


    @Test
    void testCalcSurfaceArea() {
        assertEquals(8, Rectangle.CalcSurfaceArea(4,2));
        assertEquals(1, Rectangle.CalcSurfaceArea(1,1));
      }

    @Test
    void calcCircumference() {
        assertEquals(12, recy.CalcCircumference());
      }

    @Test
    void testCalcCircumference() {
        assertEquals(12,Rectangle.CalcCircumference(4,2));
        assertEquals(4,Rectangle.CalcCircumference(1,1));
      }

    @Test
    void calcFittingIn() {
    assertEquals(8, recy.CalcFittingIn(recy2));
    assertEquals(1, recy.CalcFittingIn(recy));
    assertEquals(0,recy2.CalcFittingIn(recy3));
    assertEquals(16,recy3.CalcFittingIn(recy2));
    assertEquals(1,recy3.CalcFittingIn(recy4));
  }

    @Test
    void testCalcFittingIn() {
        assertEquals(8,recy.CalcFittingIn(8,8));
        assertEquals(0,recy.CalcFittingIn(1,1));
        assertEquals(4,recy3.CalcFittingIn(4,4));
        assertEquals(1,recy3.CalcFittingIn(1,4));
      }

    @Test
    void calcPoleDistance() {
        assertEquals(2,recy.CalcPoleDistance(5));
        assertEquals(6,recy2.CalcPoleDistance(5));
      }

    @Test
    void calcPoleAmount() {
        assertEquals(2.4,recy.CalcPoleAmount(5));
        assertEquals(4.8,recy.CalcPoleAmount(2.5));
        assertEquals(1,recy3.CalcPoleAmount(10));
      }
}