package nl.emilvdijk;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeTest {

  static InputStream inputStream = new ByteArrayInputStream("n\r\n1\r\n".getBytes());
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
  void chooseFromList() {
    ArrayList<Shape> shapeList = new ArrayList<>();
    Triangle x = new Triangle("nice",1,1,1);
    shapeList.add(x);
    Scanner myScanner = new Scanner("1\n");
    assertEquals(1,Shape.chooseFromList(shapeList,myScanner));
  }

  @Test
  void chooseNumber() {
    Scanner myScanner = new Scanner("1\n");
    int x = Shape.chooseNumber(myScanner);
    assertEquals(1,x);
    myScanner = new Scanner("n\n1\n");
    int y = Shape.chooseNumber(myScanner);
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("Please enter a number to choose."));
    assertEquals(1,y);


  }

  @Test
  void chooseDouble() {
    Scanner myScanner = new Scanner("1\n");
    double x = Shape.chooseDouble(myScanner);
    assertEquals(1.0,x);
    myScanner = new Scanner("n\n1,5\n");
    double y = Shape.chooseDouble(myScanner);
    String testOutput = outContent.toString();
    assertTrue(testOutput.contains("Please enter a number to choose."));
    assertEquals(1.5,y);
  }
}