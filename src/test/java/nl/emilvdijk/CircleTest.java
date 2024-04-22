package nl.emilvdijk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CircleTest {
    Circle circy = new Circle();
    Circle circy2 = new Circle("circy2",12);
    Circle circy3 = new Circle("circy3",0.5);

    @Test
    void diameter() {
        assertEquals(16,circy.diameter());
        assertEquals(24,circy2.diameter());
        assertEquals(1,circy3.diameter());
      }

    @Test
    void testDiameter() {
        assertEquals(16,Circle.diameter(8));
      }

    @Test
    void setRadius() {
        circy3.setRadius(2);
        assertEquals(2,circy3.radius);
      }

    @Test
    void calcCircumference() {
        assertEquals(Math.PI,circy3.calcCircumference());
      }

    @Test
    void testCalcCircumference() {
        assertEquals(Math.PI,Circle.calcCircumference(0.5));
      }

    @Test
    void calcSurfaceArea() {
        assertEquals(201.06192982974676,circy.calcSurfaceArea());
        assertEquals(0.7853981633974483,circy3.calcSurfaceArea());
      }

    @Test
    void testCalcSurfaceArea() {
        assertEquals(0.7853981633974483,Circle.calcSurfaceArea(0.5));
        assertEquals(804.247719318987,Circle.calcSurfaceArea(16));
      }

    @Test
    void calcPoleDistance() {
        assertEquals(10.053096491487338,circy.calcPoleDistance(5));
        assertEquals(0.39269908169872414,circy3.calcPoleDistance(8));

      }

    @Test
    void calcPoleAmount() {
        assertEquals(8,circy3.calcPoleAmount(0.39269908169872414));
        assertEquals(0.39269908169872414,circy3.calcPoleAmount(8));
        assertEquals(100.53096491487338,circy.calcPoleAmount(0.5));
      }

    @Test
    void circlePrinter() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
        circy3.circlePrinter();
        String testOutput = outContent.toString();
        assertTrue(testOutput.contains("Name: circy3          radius: 0.5"));
    }


}