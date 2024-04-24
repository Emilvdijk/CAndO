package nl.emilvdijk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class RectangleManagerTest {


  @Test
  void deleteRectangle2() {
    ArrayList<Shape> rectanglesList = RectangleManager.getAll();
    Rectangle recy =new Rectangle("asd",12,12);
    rectanglesList.add(recy);
    RectangleManager.deleteRectangle(1);
    assertEquals(0, rectanglesList.size());
  }

  @Test
  void addRectangle() {
    ArrayList<Shape> rectanglesList = RectangleManager.getAll();
    assertEquals(0, rectanglesList.size());
    Scanner scanner = new Scanner("nicetest\r\n12\r\n12\r\n");
    RectangleManager.addRectangle(scanner);

    assertEquals(1, rectanglesList.size());
    assertEquals("nicetest", rectanglesList.getFirst().getName());

    ArrayList<Rectangle> niceRecList = new ArrayList<>();
    niceRecList.add((Rectangle) rectanglesList.getFirst());
    assertEquals(12, niceRecList.getFirst().getLength());
    assertEquals(12, niceRecList.getFirst().getWidth());
  }
}
