package eu.irian.demo.tictactoe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldTest {

  @Test
  void test() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(1, Players.player1);
      Assertions.fail("double move");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(0, Players.player2);
      Assertions.fail("field not free");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(3, Players.nobody);
      Assertions.fail("nobody is not a valid player");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());

  }

  @Test
  void testPlaying1() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(5, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(4, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(6, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(3, Players.player1);
    Assertions.assertFalse(field.isGameOver());
  }

  @Test
  void testPlaying2() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(6, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(7, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(8, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(3, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(4, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(5, Players.player1);
    Assertions.assertTrue(field.isGameOver());
    Assertions.assertEquals(field.getWinner(), Players.nobody);
  }

  @Test
  void testPlaying3() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(6, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(5, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(7, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(4, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(8, Players.player2);
    Assertions.assertTrue(field.isGameOver());
    Assertions.assertEquals(field.getWinner(), Players.player2);
  }

  @Test
  void testPlaying4() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(3, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(6, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(4, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(5, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(8, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(7, Players.player1);
    Assertions.assertTrue(field.isGameOver());
    Assertions.assertEquals(field.getWinner(), Players.nobody);
  }

  @Test
  void testPlaying5() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(4, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(7, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(8, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(6, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(3, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    field.move(5, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player1);
    Assertions.assertTrue(field.isGameOver());
    Assertions.assertEquals(Players.player1, field.getWinner());
  }

  @Test
  void testCoordsString() {
    Field field = new Field();
    Assertions.assertEquals("row=1 column=1", field.coordsString(0));
    Assertions.assertEquals("row=1 column=2", field.coordsString(1));
    Assertions.assertEquals("row=1 column=3", field.coordsString(2));
    Assertions.assertEquals("row=2 column=1", field.coordsString(3));
    Assertions.assertEquals("row=2 column=2", field.coordsString(4));
    Assertions.assertEquals("row=2 column=3", field.coordsString(5));
    Assertions.assertEquals("row=3 column=1", field.coordsString(6));
    Assertions.assertEquals("row=3 column=2", field.coordsString(7));
    Assertions.assertEquals("row=3 column=3", field.coordsString(8));
  }
}

