package nl.emilvdijk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class TriangleTest {

  Triangle triangle = new Triangle("niceT",8,9,10);


  @Test
  void testNameGetter(){
    assertEquals("niceT",triangle.getName());
  }

  @Test
  void calcSurfaceArea() {
    assertEquals(34.197039345533994,triangle.calcSurfaceArea());
  }

  @Test
  void calcCircumference() {
    assertEquals(27,triangle.calcCircumference());
  }

  @Test
  void calcPoleDistance() {
    assertEquals(1.0,triangle.calcPoleDistance(27));
  }

  @Test
  void calcPoleAmount() {
    assertEquals(27,triangle.calcPoleAmount(1.0));
    assertEquals(54,triangle.calcPoleAmount(0.5));
  }

  @Test
  void printer(){
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
    System.out.println(triangle.toFormattedString());
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("Name: niceT           Side 1: 10     Side 2: 9      Side 3: 8"));
  }
}