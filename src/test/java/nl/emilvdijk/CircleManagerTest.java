package nl.emilvdijk;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircleManagerTest {
  static InputStream inputStream = new ByteArrayInputStream("1\r\n".getBytes());
  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  static InputStream io;


  @BeforeEach
  public void setUpStream() {
    System.setOut(new PrintStream(outContent, false, StandardCharsets.UTF_8));
    System.setIn(inputStream);
  }

  @BeforeAll
  static void replaceInputStream() {
    io = System.in;
    System.setIn(inputStream);
  }


  @Test
  void deleteCircle() {
    Circle nicecircy1 = new Circle("nice",1);
    ArrayList<Circle> circleList = new ArrayList<>();
    circleList.add(nicecircy1);

    assertEquals(1, circleList.size());
    assertTrue(circleList.contains(nicecircy1));
    CircleManager.deleteCircle(circleList);
    String testOutput = outContent.toString();
    assertEquals(0, circleList.size());
    assertTrue(testOutput.contains("Which circle would you like to delete:"));
    assertFalse(circleList.contains(nicecircy1));

  }

  @Test
  void deleteCircle2() {
    ArrayList<Circle> circleList = new ArrayList<>();

    CircleManager.deleteCircle(circleList);
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("no items to delete"));
    assertEquals(0, circleList.size());
  }

  @Test
  void addCircle() {
    ArrayList<Circle> circleList = new ArrayList<>();

    assertEquals(0, circleList.size());
    InputStream inputStream2 = new ByteArrayInputStream("nicetest\r\n12\r\n".getBytes());
    System.setIn(inputStream2);
    circleList.add(CircleManager.addCircle());
    assertEquals(1, circleList.size());
    assertEquals("nicetest",circleList.getFirst().getName());
    assertEquals(12,circleList.getFirst().getRadius());
  }
}