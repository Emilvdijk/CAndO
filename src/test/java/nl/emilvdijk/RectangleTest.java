package nl.emilvdijk;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle recy = new Rectangle();
    Rectangle recy2 = new Rectangle(8);
    Rectangle recy3 = new Rectangle("recy3",1,4);
    Rectangle recy4 = new Rectangle("recy4",4,1);



    @Test
    void calcSurfaceArea() {
        assertEquals( 8,recy.calcSurfaceArea());

      }


    @Test
    void testCalcSurfaceArea() {
        assertEquals(8, Rectangle.calcSurfaceArea(4,2));
        assertEquals(1, Rectangle.calcSurfaceArea(1,1));
      }

    @Test
    void calcCircumference() {
        assertEquals(12, recy.calcCircumference());
      }

    @Test
    void testCalcCircumference() {
        assertEquals(12,Rectangle.calcCircumference(4,2));
        assertEquals(4,Rectangle.calcCircumference(1,1));
      }

    @Test
    void calcFittingIn() {
    assertEquals(8, recy.calcFittingIn(recy2));
    assertEquals(1, recy.calcFittingIn(recy));
    assertEquals(0,recy2.calcFittingIn(recy3));
    assertEquals(16,recy3.calcFittingIn(recy2));
    assertEquals(1,recy3.calcFittingIn(recy4));
  }

    @Test
    void testCalcFittingIn() {
        assertEquals(8,recy.calcFittingIn(8,8));
        assertEquals(0,recy.calcFittingIn(1,1));
        assertEquals(4,recy3.calcFittingIn(4,4));
        assertEquals(1,recy3.calcFittingIn(1,4));
      }

    @Test
    void calcPoleDistance() {
        assertEquals(2.4,recy.calcPoleDistance(5));
        assertEquals(6.4,recy2.calcPoleDistance(5));
      }

    @Test
    void calcPoleAmount() {
        assertEquals(2.4,recy.calcPoleAmount(5));
        assertEquals(4.8,recy.calcPoleAmount(2.5));
        assertEquals(1,recy3.calcPoleAmount(10));
      }

  @Test
  void rectanglePrinter() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
    recy3.rectanglePrinter();
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("Name: recy3           Length: 1       Width: 4"));

  }
}