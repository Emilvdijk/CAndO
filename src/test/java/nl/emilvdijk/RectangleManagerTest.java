package nl.emilvdijk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleManagerTest {

//  @FIXME tests work on their own but when whole file is ran it fails


  static InputStream inputStream = new ByteArrayInputStream("1\r\n".getBytes());
  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  static InputStream io;

  @BeforeEach
  public void setUpStream() {
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
  }

  @BeforeAll
  static void replaceInputStream() {
    io = System.in;
    System.setIn(inputStream);
  }

  @Test
  void deleteRectangle() {
    Rectangle nicerecy12 = new Rectangle("nice",1,1);
    Rectangle nicerecy123 = new Rectangle("nice",1,1);
    ArrayList<Rectangle> rectanglesList2 = new ArrayList<>();

    rectanglesList2.add(nicerecy12);
    rectanglesList2.add(nicerecy123);
    assertEquals(2, rectanglesList2.size());
    RectangleManager.deleteRectangle(rectanglesList2);
    String testOutput = outContent.toString();
    assertEquals(1, rectanglesList2.size());
    assertTrue(testOutput.contains("Which rectangle would you like to delete:"));
  }


  @Test
  void deleteRectangle2() {
    ArrayList<Rectangle> rectanglesList = new ArrayList<>();

    RectangleManager.deleteRectangle(rectanglesList);
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("no items to delete"));
    assertEquals(0, rectanglesList.size());


  }

  @Test
  void addRectangle() {
    ArrayList<Rectangle> rectanglesList = new ArrayList<>();

    assertEquals(0, rectanglesList.size());
    InputStream inputStream2 = new ByteArrayInputStream("nicetest\r\n12\r\n12\r\n".getBytes());
    System.setIn(inputStream2);
    rectanglesList.add(RectangleManager.addRectangle());
    assertEquals(1, rectanglesList.size());
    assertEquals("nicetest",rectanglesList.get(0).name);
    assertEquals(12,rectanglesList.get(0).length);
    assertEquals(12,rectanglesList.get(0).width);

  }
}